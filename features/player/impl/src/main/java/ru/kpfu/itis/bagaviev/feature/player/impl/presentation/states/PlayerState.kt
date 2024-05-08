package ru.kpfu.itis.bagaviev.feature.player.impl.presentation.states

sealed class PlayerState {
    data object Playing : PlayerState()

    data object Paused : PlayerState()

    data object Next : PlayerState()

    data object Previous : PlayerState()

    data class SeekTo(val time: Long) : PlayerState()
}