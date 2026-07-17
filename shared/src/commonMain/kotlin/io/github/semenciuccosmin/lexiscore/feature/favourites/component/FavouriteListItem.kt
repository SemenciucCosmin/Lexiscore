package io.github.semenciuccosmin.lexiscore.feature.favourites.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import io.github.semenciuccosmin.lexiscore.ui.design.theme.Pds

private const val MAX_DEFINITION_LINES = 2

@Composable
fun FavouriteListItem(
    word: String,
    score: Float?,
    definition: String,
    isFavourite: Boolean,
    onClick: () -> Unit,
    onFavouriteClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    OutlinedCard(
        modifier = modifier,
        onClick = onClick
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(Pds.spacing.medium),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(Pds.spacing.sMedium)
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(Pds.spacing.small),
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = word,
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

            if (score != null) {
                Text(
                    text = score.toString(),
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.Medium
                    )
                )
            }

            FavouriteButton(
                isChecked = isFavourite,
                onClick = onFavouriteClick
            )
        }
    }
}
