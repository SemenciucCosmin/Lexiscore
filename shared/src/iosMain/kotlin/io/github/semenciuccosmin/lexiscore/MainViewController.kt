package io.github.semenciuccosmin.lexiscore

import androidx.compose.ui.window.ComposeUIViewController
import io.github.semenciuccosmin.lexiscore.domain.di.KoinInitializer
import io.github.semenciuccosmin.lexiscore.ui.app.App

fun MainViewController() = ComposeUIViewController(
    configure = {
        KoinInitializer.initKoin()
    }
) { App() }