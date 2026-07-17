package io.github.semenciuccosmin.lexiscore.feature.word.route

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import io.github.semenciuccosmin.lexiscore.feature.word.component.WordScreen
import io.github.semenciuccosmin.lexiscore.feature.word.viewmodel.WordViewModel
import io.github.semenciuccosmin.lexiscore.ui.design.theme.Pds
import lexiscore.shared.generated.resources.Res
import lexiscore.shared.generated.resources.lbl_no_word
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.parameter.parametersOf

private const val DEFAULT_SCORE = 5f

@Composable
fun WordRoute(wordId: Int) {
    val viewModel = koinViewModel<WordViewModel> { parametersOf(wordId) }
    val uiState by viewModel.uiState.collectAsState()

    uiState.word?.let { word ->
        WordScreen(
            wordId = wordId,
            description = word.description,
            definition = word.definition,
            score = word.score ?: DEFAULT_SCORE,
            isFavourite = word.isFavourite,
            onSelectScore = viewModel::setScore,
            onFavouriteClick = viewModel::setFavourite,
            onSubmitScoreClick = viewModel::submitScore,
            modifier = Modifier
                .fillMaxSize()
                .padding(Pds.spacing.medium),
        )
    } ?: run {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
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
