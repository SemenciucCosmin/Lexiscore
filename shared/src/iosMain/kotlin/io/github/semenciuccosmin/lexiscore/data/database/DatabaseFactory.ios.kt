package io.github.semenciuccosmin.lexiscore.data.database

import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.cinterop.ExperimentalForeignApi
import platform.Foundation.NSBundle
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSUserDomainMask

/**
 * iOS specific implementation for database factory
 */
actual class DatabaseFactory {

    /**
     * Creates a [LexiscoreDatabase] instance, copying the prepackaged DB from the
     * app bundle to the documents directory on the first launch.
     */
    actual fun create(): RoomDatabase.Builder<LexiscoreDatabase> {
        val dbPath = documentDirectory() + "/${LexiscoreDatabase.DATABASE_NAME}"
        copyFromBundleIfNeeded(dbPath)
        return Room.databaseBuilder<LexiscoreDatabase>(
            name = dbPath
        ).setDriver(BundledSQLiteDriver())
    }

    /**
     * Copies [LexiscoreDatabase.DATABASE_NAME] from the app bundle into [destinationPath]
     * if it has not been copied yet.
     *
     * Xcode 16's PBXFileSystemSynchronizedRootGroup preserves the folder structure inside
     * the bundle, so the file may live under a "Resources/" subdirectory. We try both
     * locations before giving up.
     */
    @OptIn(ExperimentalForeignApi::class)
    private fun copyFromBundleIfNeeded(destinationPath: String) {
        val fileManager = NSFileManager.defaultManager
        if (fileManager.fileExistsAtPath(destinationPath)) return

        // Try bundle root first, then the "Resources" sub-directory (Xcode 16+)
        val bundlePath = NSBundle.mainBundle.pathForResource(
            name = "lexiscore",
            ofType = "db"
        ) ?: NSBundle.mainBundle.pathForResource(
            name = "lexiscore",
            ofType = "db",
            inDirectory = "Resources"
        ) ?: error(
            "lexiscore.db not found in the app bundle. " +
                "Make sure it is added to the Xcode target's resources."
        )

        val success = fileManager.copyItemAtPath(
            srcPath = bundlePath,
            toPath = destinationPath,
            error = null
        )
        check(success) {
            "Failed to copy lexiscore.db from bundle ($bundlePath) to documents ($destinationPath)"
        }
    }

    /**
     * Returns the path to the documents directory on iOS.
     */
    @OptIn(ExperimentalForeignApi::class)
    private fun documentDirectory(): String {
        val documentDirectory = NSFileManager.defaultManager.URLForDirectory(
            directory = NSDocumentDirectory,
            inDomain = NSUserDomainMask,
            appropriateForURL = null,
            create = false,
            error = null
        )
        return requireNotNull(documentDirectory?.path)
    }
}