package io.github.semenciuccosmin.lexiscore.feature.word.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import io.github.semenciuccosmin.lexiscore.feature.favourites.component.FavouriteButton
import lexiscore.shared.generated.resources.Res
import lexiscore.shared.generated.resources.lbl_submit_score
import org.jetbrains.compose.resources.stringResource

@Composable
@Suppress("MagicNumber")
fun WordScreen(
    wordId: Int,
    description: String,
    definition: String,
    score: Float,
    isFavourite: Boolean,
    onSelectScore: (Float) -> Unit,
    onFavouriteClick: (Int, Boolean) -> Unit,
    onSubmitScoreClick: (Int, Float) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Spacer(modifier = Modifier.weight(0.2f))

        WordDefinitionCard(
            description = description,
            definition = definition,
        )

        Spacer(modifier = Modifier.weight(0.3f))

        ScoreSlider(
            score = score,
            onSelectScore = onSelectScore
        )

        Spacer(modifier = Modifier.weight(0.1f))

        FavouriteButton(
            isChecked = isFavourite,
            onClick = { onFavouriteClick(wordId, !isFavourite) }
        )

        Spacer(modifier = Modifier.weight(0.4f))

        Button(
            modifier = Modifier.fillMaxWidth(),
            shape = MaterialTheme.shapes.medium,
            onClick = { onSubmitScoreClick(wordId, score) }
        ) {
            Text(
                text = stringResource(Res.string.lbl_submit_score),
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}
