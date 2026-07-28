package io.github.semenciuccosmin.lexiscore.ui.design.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val LexiscoreIcons.ChevronDown: ImageVector
    get() {
        if (chevronDown != null) return chevronDown!!

        chevronDown = ImageVector.Builder(
            name = "ChevronDown",
            defaultWidth = 800.dp,
            defaultHeight = 800.dp,
            viewportWidth = 1024f,
            viewportHeight = 1024f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF000000))
            ) {
                moveTo(104.704f, 338.752f)
                arcToRelative(64f, 64f, 0f, false, true, 90.496f, 0f)
                lineToRelative(316.8f, 316.8f)
                lineToRelative(316.8f, -316.8f)
                arcToRelative(64f, 64f, 0f, false, true, 90.496f, 90.496f)
                lineTo(557.248f, 791.296f)
                arcToRelative(64f, 64f, 0f, false, true, -90.496f, 0f)
                lineTo(104.704f, 429.248f)
                arcToRelative(64f, 64f, 0f, false, true, 0f, -90.496f)
                close()
            }
        }.build()

        return chevronDown!!
    }

private var chevronDown: ImageVector? = null
