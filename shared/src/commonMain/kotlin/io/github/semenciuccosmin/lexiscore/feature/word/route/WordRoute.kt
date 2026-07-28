package io.github.semenciuccosmin.lexiscore.feature.word.route

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import io.github.semenciuccosmin.lexiscore.feature.word.component.WordScreen
import io.github.semenciuccosmin.lexiscore.feature.word.viewmodel.WordViewModel
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun WordRoute(
    wordId: Int,
    onBack: () -> Unit,
) {
    val viewModel = koinViewModel<WordViewModel> { parametersOf(wordId) }
    val uiState by viewModel.uiState.collectAsState()

    WordScreen(
        word = uiState.word,
        onSelectScore = viewModel::setScore,
        onFavouriteClick = viewModel::setFavourite,
        onSubmitScoreClick = viewModel::submitScore,
        onBack = onBack
    )
}
