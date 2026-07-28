package io.github.semenciuccosmin.lexiscore.feature.top.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import io.github.semenciuccosmin.lexiscore.ui.design.theme.Pds

private const val MAX_DEFINITION_LINES = 2

@Composable
fun TopListItem(
    index: Int,
    word: String,
    score: Float?,
    definition: String,
    tint: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    OutlinedCard(
        modifier = modifier,
        onClick = onClick,
        colors = CardDefaults.outlinedCardColors(containerColor = tint.copy(alpha = 0.05f)),
        border = BorderStroke(2.0.dp, tint)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(Pds.spacing.medium),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(Pds.spacing.sMedium)
        ) {
            Text(
                text = index.toString(),
                color = tint,
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Medium
                )
            )

            Column(
                verticalArrangement = Arrangement.spacedBy(Pds.spacing.xSmall),
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = word,
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.Medium
                    )
                )

                Text(
                    text = definition,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = MAX_DEFINITION_LINES,
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontStyle = FontStyle.Italic
                    )
                )
            }

            Text(
                text = score.toString(),
                color = tint,
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Medium
                )
            )
        }
    }
}
