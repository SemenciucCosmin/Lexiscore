package io.github.semenciuccosmin.lexiscore.feature.favourites.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.semenciuccosmin.lexiscore.data.repository.WordsRepository
import io.github.semenciuccosmin.lexiscore.feature.favourites.viewmodel.model.FavouritesUiState
import io.github.semenciuccosmin.lexiscore.ui.design.model.SortOption
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlin.collections.copy

class FavouritesViewModel(
    private val wordsRepository: WordsRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(FavouritesUiState())
    val uiState = _uiState.asStateFlow()

    init {
        getFavourites()
    }

    private fun getFavourites() {
        viewModelScope.launch {
            wordsRepository.getFavouritesAsFlow().collectLatest { words ->
                _uiState.update { it.copy(words = words.toImmutableList()) }
            }
        }
    }

    fun setFavourite(wordId: Int, isFavourite: Boolean) {
        viewModelScope.launch { wordsRepository.updateFavourite(wordId, isFavourite) }
    }

    fun setSearchQuery(searchQuery: String) {
        _uiState.update {
            it.copy(searchQuery = searchQuery)
        }
    }

    fun setSortOption(sortOption: SortOption) {
        _uiState.update { it.copy(sortOption = sortOption) }
    }
}
