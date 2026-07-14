package io.github.semenciuccosmin.lexiscore.ui.design.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import io.github.semenciuccosmin.lexiscore.ui.design.color.DarkColorScheme
import io.github.semenciuccosmin.lexiscore.ui.design.color.LightColorScheme

@Composable
fun LexiscoreTheme(content: @Composable () -> Unit) {
    val colorScheme = when {
        isSystemInDarkTheme() -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}
