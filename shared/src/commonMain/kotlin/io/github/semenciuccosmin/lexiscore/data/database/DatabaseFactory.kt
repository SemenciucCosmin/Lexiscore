package io.github.semenciuccosmin.lexiscore.data.database

import androidx.room.RoomDatabase

/**
 * Factory with platform specific implementations for creating a database instance
 */
expect class DatabaseFactory {

    /**
     * Creates a [LexiscoreDatabase] instance
     */
    fun create(): RoomDatabase.Builder<LexiscoreDatabase>
}
