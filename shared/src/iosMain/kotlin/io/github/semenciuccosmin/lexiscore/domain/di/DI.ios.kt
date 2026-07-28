package io.github.semenciuccosmin.lexiscore.domain.di

import io.github.semenciuccosmin.lexiscore.data.database.DatabaseFactory
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.darwin.Darwin
import org.koin.dsl.module

actual fun platformModule() = module {
    single { DatabaseFactory() }
    single<HttpClientEngine> { Darwin.create() }
}