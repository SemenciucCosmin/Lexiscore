package io.github.semenciuccosmin.lexiscore.feature.word.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.SliderDefaults.drawStopIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.text.font.FontWeight
import io.github.semenciuccosmin.lexiscore.ui.design.theme.Pds

private const val SLIDER_STEPS = 39
private const val MINIMUM_SCORE = 0f
private const val MAXIMUM_SCORE = 10f

@Composable
fun ScoreSlider(
    score: Float,
    onSelectScore: (Float) -> Unit,
    modifier: Modifier = Modifier,
) {
    val haptic = LocalHapticFeedback.current

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(Pds.spacing.medium),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = score.toInt().let { intPart ->
                val fracPart = ((score - intPart) * 100).toInt()
                "$intPart.${fracPart.toString().padStart(2, '0')}"
            },
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.headlineLarge.copy(
                fontWeight = FontWeight.Medium
            )
        )

        Slider(
            value = score,
            onValueChange = { value ->
                haptic.performHapticFeedback(HapticFeedbackType.SegmentTick)
                onSelectScore(value)
            },
            colors = SliderDefaults.colors(
                thumbColor = MaterialTheme.colorScheme.secondary,
                activeTrackColor = MaterialTheme.colorScheme.secondary,
                inactiveTrackColor = MaterialTheme.colorScheme.secondaryContainer,
            ),
            steps = SLIDER_STEPS,
            valueRange = MINIMUM_SCORE..MAXIMUM_SCORE,
            track = { sliderState ->
                SliderDefaults.Track(
                    modifier = Modifier.height(Pds.spacing.medium),
                    colors = SliderDefaults.colors(),
                    enabled = true,
                    sliderState = sliderState,
                    thumbTrackGapSize = Pds.spacing.xSmall,
                    drawTick = { offset, color ->
                        drawStopIndicator(
                            offset = offset,
                            color = color,
                            size = Pds.spacing.xSmall
                        )
                    }
                )
            }
        )

        Row {
            Text(
                text = MINIMUM_SCORE.toString(),
                style = MaterialTheme.typography.bodyMedium,
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = MAXIMUM_SCORE.toString(),
                style = MaterialTheme.typography.bodyMedium,
            )
        }
    }
}