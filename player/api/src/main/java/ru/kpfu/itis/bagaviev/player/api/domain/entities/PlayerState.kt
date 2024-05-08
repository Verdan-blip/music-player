package ru.kpfu.itis.bagaviev.player.api.domain.entities

data class PlayerState(
    val currentMusicItem: MusicItem? = null,
    val currentPlayingProgress: Long? = null,
    val currentPlayingItemDuration: Long? = null,
    val isPlaying: Boolean? = null
)