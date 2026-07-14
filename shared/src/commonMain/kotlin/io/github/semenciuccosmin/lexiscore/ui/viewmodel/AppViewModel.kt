package io.github.semenciuccosmin.lexiscore.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.semenciuccosmin.lexiscore.data.dao.WordsDao
import io.github.semenciuccosmin.lexiscore.ui.viewmodel.model.AppUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AppViewModel(
    private val wordsDao: WordsDao,
) : ViewModel() {

    private val _uiState = MutableStateFlow(AppUiState())
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            wordsDao.getAllAsFlow().collectLatest { words ->
                _uiState.update { it.copy(listSize = words.size) }
            }
        }
    }
}