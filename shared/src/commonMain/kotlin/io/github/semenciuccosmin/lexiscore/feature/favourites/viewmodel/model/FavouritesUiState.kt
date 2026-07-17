package io.github.semenciuccosmin.lexiscore.feature.favourites.viewmodel.model

import io.github.semenciuccosmin.lexiscore.data.model.Word
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

data class FavouritesUiState(
    val words: ImmutableList<Word> = persistentListOf()
)
