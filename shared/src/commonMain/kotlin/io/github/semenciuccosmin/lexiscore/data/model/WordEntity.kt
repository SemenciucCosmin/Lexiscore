package io.github.semenciuccosmin.lexiscore.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(
    tableName = "words",
    primaryKeys = ["id"]
)
data class WordEntity(
    @ColumnInfo(name = "id") val id: Int?,
    @ColumnInfo(name = "word") val word: String,
    @ColumnInfo(name = "definition") val definition: String?,
    @ColumnInfo(name = "score") val score: Double?,
    @ColumnInfo(name = "favourite") val favourite: Boolean?,
)
