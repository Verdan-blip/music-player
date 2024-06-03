package ru.kpfu.itis.bagaviev.feature.player.impl.presentation.states

data class PlayerUiState(
    val title: String = "Нет данных",
    val coverUri: String? = null,
    val authors: String = "Нет данных",
    val isPlaying: Boolean = false,
    val videoUri: String? = null
)