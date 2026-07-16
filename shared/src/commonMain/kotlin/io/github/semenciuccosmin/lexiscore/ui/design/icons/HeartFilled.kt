package io.github.semenciuccosmin.lexiscore.ui.design.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val LexiscoreIcons.HeartFilled: ImageVector
    get() {
        if (heartFilled != null) return heartFilled!!

        heartFilled = ImageVector.Builder(
            name = "HeartFilled",
            defaultWidth = 800.dp,
            defaultHeight = 800.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF1C274C))
            ) {
                moveTo(2f, 9.1371f)
                curveTo(2f, 14f, 6.01943f, 16.5914f, 8.96173f, 18.9109f)
                curveTo(10f, 19.7294f, 11f, 20.5f, 12f, 20.5f)
                curveTo(13f, 20.5f, 14f, 19.7294f, 15.0383f, 18.9109f)
                curveTo(17.9806f, 16.5914f, 22f, 14f, 22f, 9.1371f)
                curveTo(22f, 4.27416f, 16.4998f, 0.825464f, 12f, 5.50063f)
                curveTo(7.50016f, 0.825464f, 2f, 4.27416f, 2f, 9.1371f)
                close()
            }
        }.build()

        return heartFilled!!
    }

private var heartFilled: ImageVector? = null
