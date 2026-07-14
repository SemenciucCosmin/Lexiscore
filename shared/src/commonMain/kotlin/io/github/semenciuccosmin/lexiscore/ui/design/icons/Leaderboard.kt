package io.github.semenciuccosmin.lexiscore.ui.design.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val LexiscoreIcons.Leaderboard: ImageVector
    get() {
        if (leaderboard != null) return leaderboard!!

        leaderboard = ImageVector.Builder(
            name = "Leaderboard",
            defaultWidth = 800.dp,
            defaultHeight = 800.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 1.5f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(15f, 21f)
                horizontalLineTo(9f)
                verticalLineTo(12.6f)
                curveTo(9f, 12.2686f, 9.26863f, 12f, 9.6f, 12f)
                horizontalLineTo(14.4f)
                curveTo(14.7314f, 12f, 15f, 12.2686f, 15f, 12.6f)
                verticalLineTo(21f)
                close()
            }
            path(
                stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 1.5f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(20.4f, 21f)
                horizontalLineTo(15f)
                verticalLineTo(18.1f)
                curveTo(15f, 17.7686f, 15.2686f, 17.5f, 15.6f, 17.5f)
                horizontalLineTo(20.4f)
                curveTo(20.7314f, 17.5f, 21f, 17.7686f, 21f, 18.1f)
                verticalLineTo(20.4f)
                curveTo(21f, 20.7314f, 20.7314f, 21f, 20.4f, 21f)
                close()
            }
            path(
                stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 1.5f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(9f, 21f)
                verticalLineTo(16.1f)
                curveTo(9f, 15.7686f, 8.73137f, 15.5f, 8.4f, 15.5f)
                horizontalLineTo(3.6f)
                curveTo(3.26863f, 15.5f, 3f, 15.7686f, 3f, 16.1f)
                verticalLineTo(20.4f)
                curveTo(3f, 20.7314f, 3.26863f, 21f, 3.6f, 21f)
                horizontalLineTo(9f)
                close()
            }
            path(
                stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 1.5f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(10.8056f, 5.11325f)
                lineTo(11.7147f, 3.1856f)
                curveTo(11.8314f, 2.93813f, 12.1686f, 2.93813f, 12.2853f, 3.1856f)
                lineTo(13.1944f, 5.11325f)
                lineTo(15.2275f, 5.42427f)
                curveTo(15.4884f, 5.46418f, 15.5923f, 5.79977f, 15.4035f, 5.99229f)
                lineTo(13.9326f, 7.4917f)
                lineTo(14.2797f, 9.60999f)
                curveTo(14.3243f, 9.88202f, 14.0515f, 10.0895f, 13.8181f, 9.96099f)
                lineTo(12f, 8.96031f)
                lineTo(10.1819f, 9.96099f)
                curveTo(9.94851f, 10.0895f, 9.67568f, 9.88202f, 9.72026f, 9.60999f)
                lineTo(10.0674f, 7.4917f)
                lineTo(8.59651f, 5.99229f)
                curveTo(8.40766f, 5.79977f, 8.51163f, 5.46418f, 8.77248f, 5.42427f)
                lineTo(10.8056f, 5.11325f)
                close()
            }
        }.build()

        return leaderboard!!
    }

private var leaderboard: ImageVector? = null
