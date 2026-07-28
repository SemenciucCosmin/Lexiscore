package io.github.semenciuccosmin.lexiscore.data.repository

import io.github.semenciuccosmin.lexiscore.data.model.Word
import kotlinx.coroutines.flow.Flow

interface WordsRepository {
    suspend fun getWordById(id: Int): Word?

    suspend fun getRandomUnscoredWord(): Word?

    suspend fun updateScore(id: Int, score: Double)

    suspend fun updateFavourite(id: Int, favourite: Boolean)

    fun getTotalCountAsFlow(): Flow<Int>

    fun getScoredCountAsFlow(): Flow<Int>

    fun getFavouritesAsFlow(): Flow<List<Word>>

    fun getScoredAsFlow(): Flow<List<Word>>
}
