package io.github.semenciuccosmin.lexiscore.feature.favourites.viewmodel.model

import io.github.semenciuccosmin.lexiscore.data.model.Word
import io.github.semenciuccosmin.lexiscore.ui.design.model.SortOption
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList

data class FavouritesUiState(
    private val words: ImmutableList<Word> = persistentListOf(),
    val searchQuery: String = "",
    val sortOption: SortOption = SortOption.ALPHABETICAL,
) {
    val filteredWords: ImmutableList<Word>
        get(): ImmutableList<Word> {
            val filtered = when {
                searchQuery.isBlank() -> words
                else -> words.filter {
                    it.description.contains(searchQuery, ignoreCase = true)
                }.toImmutableList()
            }

            return when (sortOption) {
                SortOption.SCORE_DESCENDING -> filtered.sortedByDescending { it.score }
                SortOption.SCORE_ASCENDING -> filtered.sortedBy { it.score }
                SortOption.ALPHABETICAL -> filtered.sortedBy { it.description }
                SortOption.REVERSE_ALPHABETICAL -> filtered.sortedByDescending { it.description }
            }.toImmutableList()
        }
}
