package io.github.semenciuccosmin.lexiscore.domain.di

import io.github.semenciuccosmin.lexiscore.data.database.DatabaseFactory
import io.github.semenciuccosmin.lexiscore.data.database.LexiscoreDatabase
import io.github.semenciuccosmin.lexiscore.data.network.service.DexOnlineApi
import io.github.semenciuccosmin.lexiscore.data.repository.WordsRepository
import io.github.semenciuccosmin.lexiscore.data.repository.WordsRepositoryImpl
import io.github.semenciuccosmin.lexiscore.feature.favourites.viewmodel.FavouritesViewModel
import io.github.semenciuccosmin.lexiscore.feature.review.viewmodel.ReviewViewModel
import io.github.semenciuccosmin.lexiscore.feature.top.viewmodel.TopViewModel
import io.github.semenciuccosmin.lexiscore.feature.word.viewmodel.WordViewModel
import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.serialization.json.Json
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

private const val TIMEOUT_MILLIS = 20_000L

expect fun platformModule(): Module

fun commonModule() = module {
    includes(platformModule())
    factory<WordsRepository> { WordsRepositoryImpl(get(), get()) }
    single { get<DatabaseFactory>().create().build() }
    single { get<LexiscoreDatabase>().wordsDao }
    single { CoroutineScope(SupervisorJob() + Dispatchers.Default) }

    viewModelOf(::ReviewViewModel)
    viewModelOf(::FavouritesViewModel)
    viewModelOf(::TopViewModel)
    viewModelOf(::WordViewModel)

    single<HttpClient> {
        HttpClient(engine = get()) {
            install(ContentNegotiation) {
                json(Json { ignoreUnknownKeys = true })
            }

            install(HttpTimeout) {
                socketTimeoutMillis = TIMEOUT_MILLIS
                requestTimeoutMillis = TIMEOUT_MILLIS
            }

            install(Logging) {
                level = LogLevel.ALL
                logger = object : Logger {
                    override fun log(message: String) {
                        println(message)
                    }
                }
            }

            defaultRequest {
                contentType(ContentType.Application.Json)
            }
        }
    }

    factory<DexOnlineApi> { DexOnlineApi(get()) }
}
