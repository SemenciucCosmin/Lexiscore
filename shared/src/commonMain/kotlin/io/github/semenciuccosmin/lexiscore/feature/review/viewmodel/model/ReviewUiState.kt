package io.github.semenciuccosmin.lexiscore.feature.review.viewmodel.model

data class ReviewUiState(
    val id: Int? = null,
    val description: String = "",
    val definition: String = "",
    val score: Float = 5f,
    val isFavourite: Boolean = false,
    val totalWordCount: Int = 0,
    val scoredWordCount: Int = 0,
    val completionPercentage: Float = 0f,
    val isSubmitted: Boolean = true
)