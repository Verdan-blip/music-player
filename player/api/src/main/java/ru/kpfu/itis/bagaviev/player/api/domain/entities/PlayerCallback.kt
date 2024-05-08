package ru.kpfu.itis.bagaviev.player.api.domain.entities

sealed class PlayerCallback {

    data object PlayerInitialized : PlayerCallback()

    data class IsPlayingChanged(val isPlaying: Boolean) : PlayerCallback()

    data class MusicItemChanged(val musicItem: MusicItem) : PlayerCallback()

    data class ItemDurationChanged(val duration: Long) : PlayerCallback()

    data class PlayingPositionChanged(val positionInMs: Long) : PlayerCallback()
}