package io.github.semenciuccosmin.lexiscore.domain.extensions

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

/**
 * Composable function for getting the Context from specific platform
 */
@Composable
actual fun getContext(): Any? {
    return LocalContext.current
}