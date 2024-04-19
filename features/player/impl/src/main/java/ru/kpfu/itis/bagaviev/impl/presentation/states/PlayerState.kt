package ru.kpfu.itis.bagaviev.impl.presentation.states

sealed class PlayerState {
    data object Playing : PlayerState()

    data object Paused : PlayerState()

    data object Next : PlayerState()

    data object Previous : PlayerState()

    data class SeekTo(val time: Long) : PlayerState()
}