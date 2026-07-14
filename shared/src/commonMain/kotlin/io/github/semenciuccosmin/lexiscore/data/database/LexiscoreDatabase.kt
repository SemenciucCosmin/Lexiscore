package io.github.semenciuccosmin.lexiscore.data.database

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import io.github.semenciuccosmin.lexiscore.data.dao.WordsDao
import io.github.semenciuccosmin.lexiscore.data.model.WordEntity

@Database(
    version = 1,
    exportSchema = true,
    entities = [
        WordEntity::class,
    ],
    autoMigrations = []
)
@ConstructedBy(LexiscoreDatabaseConstructor::class)
abstract class LexiscoreDatabase : RoomDatabase() {

    abstract val wordsDao: WordsDao

    companion object {
        const val DATABASE_NAME = "lexiscore.db"
    }
}
