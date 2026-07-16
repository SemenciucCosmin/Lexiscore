package io.github.semenciuccosmin.lexiscore.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.github.semenciuccosmin.lexiscore.data.model.WordEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface WordsDao {

    @Query("SELECT * FROM words")
    fun getAllAsFlow(): Flow<List<WordEntity>>

    @Query("SELECT * FROM words WHERE score IS NULL ORDER BY RANDOM() LIMIT 1")
    fun getRandomUnscoredAsFlow(): Flow<WordEntity?>

    @Query("UPDATE words SET score = :score WHERE id = :id")
    suspend fun updateScore(id: Int, score: Double)

    @Query("UPDATE words SET favourite = :favourite WHERE id = :id")
    suspend fun updateFavourite(id: Int, favourite: Boolean)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity: WordEntity)

    @Query("SELECT COUNT(*) FROM words")
    fun getTotalCountAsFlow(): Flow<Int>

    @Query("SELECT COUNT(*) FROM words WHERE score IS NOT NULL")
    fun getScoredCountAsFlow(): Flow<Int>
}
