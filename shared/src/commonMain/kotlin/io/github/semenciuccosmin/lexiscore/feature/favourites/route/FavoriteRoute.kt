package io.github.semenciuccosmin.lexiscore.feature.favourites.route

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import io.github.semenciuccosmin.lexiscore.feature.favourites.component.FavouritesScreen
import io.github.semenciuccosmin.lexiscore.feature.favourites.viewmodel.FavouritesViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun FavouriteRoute(onItemClick: (Int) -> Unit) {
    val viewModel = koinViewModel<FavouritesViewModel>()
    val uiState by viewModel.uiState.collectAsState()

    FavouritesScreen(
        words = uiState.words,
        onItemClick = onItemClick,
        onFavouriteClick = viewModel::setFavourite
    )
}