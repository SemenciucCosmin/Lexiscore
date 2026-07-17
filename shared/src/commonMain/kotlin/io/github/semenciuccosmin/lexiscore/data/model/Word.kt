package io.github.semenciuccosmin.lexiscore.data.model

data class Word(
    val id: Int,
    val description: String,
    val definition: String,
    val score: Float?,
    val isFavourite: Boolean
)