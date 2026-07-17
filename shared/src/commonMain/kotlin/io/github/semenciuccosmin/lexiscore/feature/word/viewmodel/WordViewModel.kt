package io.github.semenciuccosmin.lexiscore.feature.word.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.semenciuccosmin.lexiscore.data.repository.WordsRepository
import io.github.semenciuccosmin.lexiscore.feature.word.viewmodel.model.WordUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class WordViewModel(
    private val wordId: Int,
    private val wordsRepository: WordsRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow(WordUiState())
    val uiState = _uiState.asStateFlow()

    init {
        getWord()
    }

    private fun getWord() {
        viewModelScope.launch {
            _uiState.update { it.copy(word = wordsRepository.getWordById(wordId)) }
        }
    }

    fun setScore(score: Float) {
        _uiState.update { it.copy(word = it.word?.copy(score = score)) }
    }

    fun submitScore(wordId: Int, score: Float) {
        viewModelScope.launch { wordsRepository.updateScore(wordId, score.toDouble()) }
    }

    fun setFavourite(wordId: Int, isFavourite: Boolean) {
        _uiState.update {
            it.copy(word = it.word?.copy(isFavourite = isFavourite))
        }
        viewModelScope.launch { wordsRepository.updateFavourite(wordId, isFavourite) }
    }
}
