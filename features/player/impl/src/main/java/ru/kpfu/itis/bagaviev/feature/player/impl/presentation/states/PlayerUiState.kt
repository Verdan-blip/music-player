package ru.kpfu.itis.bagaviev.feature.player.impl.presentation.states

import android.net.Uri

data class PlayerUiState(
    val title: String = "Нет данных",
    val coverUri: Uri? = null,
    val authors: String = "Нет данных",
    val isPlaying: Boolean = false,
    val videoUri: Uri? = null
)