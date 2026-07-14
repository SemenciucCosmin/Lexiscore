package io.github.semenciuccosmin.lexiscore.domain.di

import io.github.semenciuccosmin.lexiscore.data.database.DatabaseFactory
import io.github.semenciuccosmin.lexiscore.data.database.LexiscoreDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import org.koin.core.module.Module
import org.koin.dsl.module

expect fun platformModule(): Module

fun commonModule() = module {
    includes(platformModule())
    single { get<DatabaseFactory>().create().build() }
    single { get<LexiscoreDatabase>().wordsDao }
    single { CoroutineScope(SupervisorJob() + Dispatchers.Default) }
}
