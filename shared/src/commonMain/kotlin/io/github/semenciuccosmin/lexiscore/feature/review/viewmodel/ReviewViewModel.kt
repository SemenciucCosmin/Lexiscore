package io.github.semenciuccosmin.lexiscore.feature.review.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.semenciuccosmin.lexiscore.data.repository.WordsRepository
import io.github.semenciuccosmin.lexiscore.feature.review.viewmodel.model.ReviewUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ReviewViewModel(
    private val wordsRepository: WordsRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(ReviewUiState())
    val uiState = _uiState.asStateFlow()

    init {
        getWordsForReview()
        getTotalWordsCount()
        getScoredWordsCount()
    }

    private fun getScoredWordsCount() {
        viewModelScope.launch {
            wordsRepository.getTotalCountAsFlow().collectLatest { totalWordCount ->
                _uiState.update { it.copy(totalWordCount = totalWordCount) }
            }
        }
    }

    private fun getTotalWordsCount() {
        viewModelScope.launch {
            wordsRepository.getScoredCountAsFlow().collectLatest { totalWordCount ->
                _uiState.update { it.copy(scoredWordCount = totalWordCount) }
            }
        }
    }

    private fun getWordsForReview() {
        viewModelScope.launch {
            wordsRepository.getRandomUnscoredAsFlow().filterNotNull().collectLatest { word ->
                if (!_uiState.value.isSubmitted &&_uiState.value.id != word.id) {
                    return@collectLatest
                }

                _uiState.update {
                    it.copy(
                        id = word.id,
                        description = word.description,
                        definition = word.definition,
                        isFavourite = word.isFavourite,
                        isSubmitted = false
                    )
                }
            }
        }
    }

    fun setScore(score: Float) {
        _uiState.update { it.copy(score = score) }
    }

    fun submitScore(wordId: Int, score: Float) {
        _uiState.update { it.copy(isSubmitted = true) }
        viewModelScope.launch { wordsRepository.updateScore(wordId, score.toDouble()) }
    }

    fun setFavourite(wordId: Int, isFavourite: Boolean) {
        _uiState.update { it.copy(isFavourite = isFavourite) }
        viewModelScope.launch { wordsRepository.updateFavourite(wordId, isFavourite) }
    }
}
