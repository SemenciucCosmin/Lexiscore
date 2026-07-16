package io.github.semenciuccosmin.lexiscore.feature.review.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import io.github.semenciuccosmin.lexiscore.feature.favourites.component.FavouriteButton
import io.github.semenciuccosmin.lexiscore.feature.review.viewmodel.ReviewUiState
import io.github.semenciuccosmin.lexiscore.ui.design.theme.Pds
import lexiscore.shared.generated.resources.Res
import lexiscore.shared.generated.resources.lbl_submit_score
import org.jetbrains.compose.resources.stringResource

@Composable
@Suppress("MagicNumber")
fun ReviewScreen(
    uiState: ReviewUiState,
    onSelectScore: (Float) -> Unit,
    onFavouriteClick: (Int, Boolean) -> Unit,
    onSubmitScoreClick: (Int, Float) -> Unit,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(Pds.spacing.medium)
            .fillMaxSize()
    ) {
        Text(
            text = "${uiState.scoredWordCount} / ${uiState.totalWordCount}",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.weight(0.2f))

        WordDefinitionCard(
            description = uiState.description,
            definition = uiState.definition,
        )

        Spacer(modifier = Modifier.weight(0.3f))

        ScoreSlider(
            score = uiState.score,
            onSelectScore = onSelectScore
        )

        Spacer(modifier = Modifier.weight(0.1f))

        FavouriteButton(
            isChecked = uiState.isFavourite,
            onClick = {
                uiState.id?.let {
                    onFavouriteClick(it, !uiState.isFavourite)
                }
            }
        )

        Spacer(modifier = Modifier.weight(0.4f))

        Button(
            modifier = Modifier.fillMaxWidth(),
            shape = MaterialTheme.shapes.medium,
            onClick = {
                uiState.id?.let {
                    onSubmitScoreClick(it, uiState.score)
                }
            }
        ) {
            Text(
                text = stringResource(Res.string.lbl_submit_score),
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}
