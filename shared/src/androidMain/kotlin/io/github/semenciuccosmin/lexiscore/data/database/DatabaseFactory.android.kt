package io.github.semenciuccosmin.lexiscore.data.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Android specific implementation for database factory
 */
actual class DatabaseFactory(private val context: Context) {

    /**
     * Creates a [LexiscoreDatabase] instance with prepopulated data from assets
     */
    actual fun create(): RoomDatabase.Builder<LexiscoreDatabase> {
        val appContext = context.applicationContext

        return Room.databaseBuilder<LexiscoreDatabase>(
            context = appContext,
            name = LexiscoreDatabase.DATABASE_NAME
        ).createFromAsset("database/${LexiscoreDatabase.DATABASE_NAME}")
    }
}
