package io.github.semenciuccosmin.lexiscore.feature.review.route

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import io.github.semenciuccosmin.lexiscore.feature.review.viewmodel.model.ReviewUiState
import io.github.semenciuccosmin.lexiscore.feature.word.component.WordScreen
import io.github.semenciuccosmin.lexiscore.ui.design.theme.Pds

@Composable
@Suppress("MagicNumber")
fun ReviewScreen(
    uiState: ReviewUiState,
    onSelectScore: (Float) -> Unit,
    onFavouriteClick: (Int, Boolean) -> Unit,
    onSubmitScoreClick: (Int, Float) -> Unit,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(Pds.spacing.small),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(Pds.spacing.medium)
            .fillMaxSize()
    ) {
        Text(
            text = "${uiState.scoredWordCount} / ${uiState.totalWordCount}",
            style = MaterialTheme.typography.titleMedium
        )

        Text(
            text = uiState.completionPercentage.toInt().let { intPart ->
                val fracPart = ((uiState.completionPercentage - intPart) * 100).toInt()
                "$intPart.${fracPart.toString().padStart(2, '0')}%"
            },
            style = MaterialTheme.typography.titleMedium
        )

        WordScreen(
            wordId = uiState.id ?: return,
            description = uiState.description,
            definition = uiState.definition,
            score = uiState.score,
            isFavourite = uiState.isFavourite,
            onSelectScore = onSelectScore,
            onFavouriteClick = onFavouriteClick,
            onSubmitScoreClick = onSubmitScoreClick
        )
    }
}
