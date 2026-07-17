package io.github.semenciuccosmin.lexiscore.feature.review.route

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import io.github.semenciuccosmin.lexiscore.feature.review.viewmodel.ReviewViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ReviewRoute() {
    val viewModel = koinViewModel<ReviewViewModel>()
    val uiState = viewModel.uiState.collectAsState()

    ReviewScreen(
        uiState = uiState.value,
        onSelectScore = viewModel::setScore,
        onFavouriteClick = viewModel::setFavourite,
        onSubmitScoreClick = viewModel::submitScore
    )
}
