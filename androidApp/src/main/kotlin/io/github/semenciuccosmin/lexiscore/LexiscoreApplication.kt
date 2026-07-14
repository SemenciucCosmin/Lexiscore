package io.github.semenciuccosmin.lexiscore

import android.app.Application
import io.github.semenciuccosmin.lexiscore.domain.di.KoinInitializer
import org.koin.android.ext.koin.androidContext

class LexiscoreApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        KoinInitializer.initKoin {
            androidContext(this@LexiscoreApplication)
        }
    }
}
