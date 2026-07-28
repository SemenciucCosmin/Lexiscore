package io.github.semenciuccosmin.lexiscore.feature.top.route

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import io.github.semenciuccosmin.lexiscore.feature.top.component.TopScreen
import io.github.semenciuccosmin.lexiscore.feature.top.viewmodel.TopViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun TopRoute(onItemClick: (Int) -> Unit) {
    val viewModel = koinViewModel<TopViewModel>()
    val uiState by viewModel.uiState.collectAsState()

    TopScreen(
        descendingWords = uiState.descendingWords,
        words = uiState.filteredWords,
        query = uiState.searchQuery,
        sortOption = uiState.sortOption,
        onItemClick = onItemClick,
        onChangeQuery = viewModel::setSearchQuery,
        onSelectSortOption = viewModel::setSortOption,
        onClearClick = { viewModel.setSearchQuery("") }
    )
}