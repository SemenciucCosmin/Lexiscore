package io.github.semenciuccosmin.lexiscore.domain.di

import io.github.semenciuccosmin.lexiscore.data.database.DatabaseFactory
import org.koin.dsl.module

actual fun platformModule() = module {
    single { DatabaseFactory(get()) }
}