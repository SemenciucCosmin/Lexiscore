package io.github.semenciuccosmin.lexiscore.ui.design.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val LexiscoreIcons.Dictionary: ImageVector
    get() {
        if (dictionary != null) return dictionary!!

        dictionary = ImageVector.Builder(
            name = "Dictionary",
            defaultWidth = 800.dp,
            defaultHeight = 800.dp,
            viewportWidth = 192f,
            viewportHeight = 192f
        ).apply {
            group {
                path(
                    stroke = SolidColor(Color(0xFF000000)),
                    strokeLineWidth = 12f,
                    strokeLineCap = StrokeCap.Round,
                    strokeLineJoin = StrokeJoin.Round,
                    strokeLineMiter = 15f
                ) {
                    moveToRelative(161.57f, 33.908f)
                    lineToRelative(-6.192f, 123.99f)
                    moveTo(35.471f, 31.427f)
                    lineToRelative(107.75f, -9.428f)
                    moveTo(61.069f, 169.92f)
                    lineToRelative(94.309f, -12.023f)
                    moveTo(35.471f, 31.427f)
                    lineToRelative(2.323f, 122.3f)
                    curveToRelative(0.23f, 12.109f, 20.347f, 16.56f, 23.275f, 16.187f)
                    moveTo(60.626f, 42.74f)
                    lineToRelative(100.94f, -8.833f)
                    moveTo(60.626f, 42.74f)
                    curveToRelative(-13.948f, 1.22f, -25.155f, -11.314f, -25.155f, -11.314f)
                    moveTo(143.23f, 21.998f)
                    lineToRelative(0.265f, 13.492f)
                    moveTo(134.23f, 59.235f)
                    lineToRelative(-15.213f, 74.535f)
                    moveTo(121.5f, 121.62f)
                    curveToRelative(-13.8f, 8.658f, -25.142f, 14.948f, -33.433f, 12.947f)
                    curveToRelative(-8.292f, -2.002f, -6.862f, -14.868f, -6.672f, -17.823f)
                    curveToRelative(0.191f, -2.955f, 6.481f, -25.257f, 22.97f, -29.736f)
                    reflectiveCurveToRelative(22.735f, 7.176f, 22.735f, 7.176f)
                }
            }
        }.build()

        return dictionary!!
    }

private var dictionary: ImageVector? = null
