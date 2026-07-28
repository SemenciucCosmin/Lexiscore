package io.github.semenciuccosmin.lexiscore.feature.word.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import io.github.semenciuccosmin.lexiscore.data.model.Word
import io.github.semenciuccosmin.lexiscore.ui.design.components.TopBar
import io.github.semenciuccosmin.lexiscore.ui.design.theme.Pds
import lexiscore.shared.generated.resources.Res
import lexiscore.shared.generated.resources.lbl_no_word
import lexiscore.shared.generated.resources.lbl_word
import org.jetbrains.compose.resources.stringResource

private const val DEFAULT_SCORE = 5f

@Composable
fun WordScreen(
    word: Word?,
    onBack: () -> Unit,
    onSelectScore: (Float) -> Unit,
    onFavouriteClick: (Int, Boolean) -> Unit,
    onSubmitScoreClick: (Int, Float) -> Unit,
) {
    Scaffold(
        topBar = {
            TopBar(
                title = word?.description ?: stringResource(Res.string.lbl_word),
                onBack = onBack
            )
        }
    ) { paddingValues ->
        when {
            word != null -> {
                WordDetails(
                    wordId = word.id,
                    description = word.description,
                    definition = word.definition,
                    score = word.score ?: DEFAULT_SCORE,
                    isFavourite = word.isFavourite,
                    onSelectScore = onSelectScore,
                    onFavouriteClick = onFavouriteClick,
                    onSubmitScoreClick = onSubmitScoreClick,
                    modifier = Modifier
                        .padding(paddingValues)
                        .fillMaxSize()
                        .padding(Pds.spacing.medium),
                )
            }

            else -> {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(paddingValues)
                        .fillMaxSize()
                        .padding(Pds.spacing.medium),
                ) {
                    Text(
                        text = stringResource(Res.string.lbl_no_word),
                        style = MaterialTheme.typography.titleMedium
                    )
                }
            }
        }
    }
}
