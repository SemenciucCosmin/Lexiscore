package io.github.semenciuccosmin.lexiscore.ui.design.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val LexiscoreIcons.WordSearch: ImageVector
    get() {
        if (wordSearch != null) return wordSearch!!

        wordSearch = ImageVector.Builder(
            name = "WordSearch",
            defaultWidth = 800.dp,
            defaultHeight = 800.dp,
            viewportWidth = 192f,
            viewportHeight = 192f
        ).apply {
            path(
                stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 12f
            ) {
                moveTo(170f, 76f)
                arcTo(54f, 54f, 0f, false, true, 116f, 130f)
                arcTo(54f, 54f, 0f, false, true, 62f, 76f)
                arcTo(54f, 54f, 0f, false, true, 170f, 76f)
                close()
            }
            path(
                stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 12f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(86.5f, 121.5f)
                lineTo(41f, 167f)
                curveToRelative(-4.418f, 4.418f, -11.582f, 4.418f, -16f, 0f)
                verticalLineToRelative(0f)
                curveToRelative(-4.418f, -4.418f, -4.418f, -11.582f, 0f, -16f)
                lineToRelative(44.5f, -44.5f)
                moveTo(92f, 62f)
                lineToRelative(12f, 32f)
                lineToRelative(12f, -32f)
                lineToRelative(12f, 32f)
                lineToRelative(12f, -32f)
            }
        }.build()

        return wordSearch!!
    }

private var wordSearch: ImageVector? = null
