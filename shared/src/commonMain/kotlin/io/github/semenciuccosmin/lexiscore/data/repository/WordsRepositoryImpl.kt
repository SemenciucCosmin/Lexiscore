package io.github.semenciuccosmin.lexiscore.data.repository

import io.github.semenciuccosmin.lexiscore.data.dao.WordsDao
import io.github.semenciuccosmin.lexiscore.data.model.Word
import io.github.semenciuccosmin.lexiscore.data.model.WordEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapNotNull

class WordsRepositoryImpl(
    private val wordsDao: WordsDao
) : WordsRepository {

    override suspend fun getWordById(id: Int): Word? {
        return mapEntityToModel(wordsDao.getWordById(id))
    }

    override fun getRandomUnscoredAsFlow(): Flow<Word?> {
        return wordsDao.getRandomUnscoredAsFlow().mapNotNull(::mapEntityToModel)
    }

    override suspend fun updateScore(id: Int, score: Double) {
        wordsDao.updateScore(id, score)
    }

    override suspend fun updateFavourite(id: Int, favourite: Boolean) {
        wordsDao.updateFavourite(id, favourite)
    }

    override fun getTotalCountAsFlow(): Flow<Int> {
        return wordsDao.getTotalCountAsFlow()
    }

    override fun getScoredCountAsFlow(): Flow<Int> {
        return wordsDao.getScoredCountAsFlow()
    }

    override fun getFavouritesAsFlow(): Flow<List<Word>> {
        return wordsDao.getFavouritesAsFlow().map { entities ->
            entities.mapNotNull(::mapEntityToModel)
        }
    }

    private fun mapEntityToModel(entity: WordEntity?): Word? {
        return Word(
            id = entity?.id ?: return null,
            description = entity.word,
            definition = entity.definition.orEmpty(),
            score = entity.score?.toFloat(),
            isFavourite = entity.favourite == true,
        )
    }
}
