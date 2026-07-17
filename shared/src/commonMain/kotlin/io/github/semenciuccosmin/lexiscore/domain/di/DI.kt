package io.github.semenciuccosmin.lexiscore.domain.di

import io.github.semenciuccosmin.lexiscore.data.database.DatabaseFactory
import io.github.semenciuccosmin.lexiscore.data.database.LexiscoreDatabase
import io.github.semenciuccosmin.lexiscore.data.repository.WordsRepository
import io.github.semenciuccosmin.lexiscore.data.repository.WordsRepositoryImpl
import io.github.semenciuccosmin.lexiscore.feature.favourites.viewmodel.FavouritesViewModel
import io.github.semenciuccosmin.lexiscore.feature.review.viewmodel.ReviewViewModel
import io.github.semenciuccosmin.lexiscore.feature.word.viewmodel.WordViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

expect fun platformModule(): Module

fun commonModule() = module {
    includes(platformModule())
    factory<WordsRepository> { WordsRepositoryImpl(get()) }
    single { get<DatabaseFactory>().create().build() }
    single { get<LexiscoreDatabase>().wordsDao }
    single { CoroutineScope(SupervisorJob() + Dispatchers.Default) }

    viewModelOf(::ReviewViewModel)
    viewModelOf(::FavouritesViewModel)
    viewModelOf(::WordViewModel)
}
