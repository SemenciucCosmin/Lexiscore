package io.github.semenciuccosmin.lexiscore.feature.review.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.semenciuccosmin.lexiscore.data.dao.WordsDao
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ReviewViewModel(
    private val wordsDao: WordsDao,
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
            wordsDao.getTotalCountAsFlow().collectLatest { totalWordCount ->
                _uiState.update { it.copy(totalWordCount = totalWordCount) }
            }
        }
    }

    private fun getTotalWordsCount() {
        viewModelScope.launch {
            wordsDao.getScoredCountAsFlow().collectLatest { totalWordCount ->
                _uiState.update { it.copy(scoredWordCount = totalWordCount) }
            }
        }
    }

    private fun getWordsForReview() {
        viewModelScope.launch {
            wordsDao.getRandomUnscoredAsFlow().filterNotNull().collectLatest { word ->
                if (!_uiState.value.isSubmitted) return@collectLatest
                _uiState.update {
                    it.copy(
                        id = word.id,
                        description = word.word,
                        definition = word.definition.orEmpty(),
                        isFavourite = word.favourite == true,
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
        viewModelScope.launch { wordsDao.updateScore(wordId, score.toDouble()) }
    }

    fun setFavourite(wordId: Int, isFavourite: Boolean) {
        _uiState.update { it.copy(isFavourite = isFavourite) }
        viewModelScope.launch { wordsDao.updateFavourite(wordId, isFavourite) }
    }
}
