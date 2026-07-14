package io.github.semenciuccosmin.lexiscore

import androidx.compose.ui.window.ComposeUIViewController
import io.github.semenciuccosmin.lexiscore.domain.di.KoinInitializer
import io.github.semenciuccosmin.lexiscore.feature.app.App

@Suppress("FunctionNaming")
fun MainViewController() = ComposeUIViewController(
    configure = {
        KoinInitializer.initKoin()
    }
) { App() }