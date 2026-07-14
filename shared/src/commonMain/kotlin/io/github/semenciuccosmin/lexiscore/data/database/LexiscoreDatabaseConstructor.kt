package io.github.semenciuccosmin.lexiscore.data.database

import androidx.room.RoomDatabaseConstructor

/**
 * Factory with platform specific implementations for creating a database instance
 */
@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object LexiscoreDatabaseConstructor : RoomDatabaseConstructor<LexiscoreDatabase> {

    /**
     * Creates a [LexiscoreDatabase] instance
     */
    override fun initialize(): LexiscoreDatabase
}
