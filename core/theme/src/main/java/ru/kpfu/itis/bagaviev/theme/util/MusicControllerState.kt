package ru.kpfu.itis.bagaviev.theme.util

data class MusicControllerState(
    val isPlayingNow: Boolean,
    val progressInMs: Long,
    val durationInMs: Long
)