package io.github.semenciuccosmin.lexiscore.feature.top.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.semenciuccosmin.lexiscore.data.repository.WordsRepository
import io.github.semenciuccosmin.lexiscore.feature.top.viewmodel.model.TopUiState
import io.github.semenciuccosmin.lexiscore.ui.design.model.SortOption
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class TopViewModel(
    private val wordsRepository: WordsRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(TopUiState())
    val uiState = _uiState.asStateFlow()

    init {
        getWords()
    }

    private fun getWords() {
        viewModelScope.launch {
            wordsRepository.getScoredAsFlow().collectLatest { words ->
                _uiState.update { it.copy(words = words.toImmutableList()) }
            }
        }
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
