package io.github.semenciuccosmin.lexiscore.ui.design.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val LexiscoreIcons.CloseCircle: ImageVector
    get() {
        if (closeCircle != null) return closeCircle!!

        closeCircle = ImageVector.Builder(
            name = "CloseCircle",
            defaultWidth = 800.dp,
            defaultHeight = 800.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF000000))
            ) {
                moveTo(12f, 2f)
                arcTo(10f, 10f, 0f, true, false, 22f, 12f)
                arcTo(10f, 10f, 0f, false, false, 12f, 2f)
                close()
                moveToRelative(3.707f, 12.293f)
                arcToRelative(1f, 1f, 0f, true, true, -1.414f, 1.414f)
                lineTo(12f, 13.414f)
                lineTo(9.707f, 15.707f)
                arcToRelative(1f, 1f, 0f, false, true, -1.414f, -1.414f)
                lineTo(10.586f, 12f)
                lineTo(8.293f, 9.707f)
                arcTo(1f, 1f, 0f, false, true, 9.707f, 8.293f)
                lineTo(12f, 10.586f)
                lineToRelative(2.293f, -2.293f)
                arcToRelative(1f, 1f, 0f, false, true, 1.414f, 1.414f)
                lineTo(13.414f, 12f)
                close()
            }
        }.build()

        return closeCircle!!
    }

private var closeCircle: ImageVector? = null
