package ru.kpfu.itis.bagaviev.player.impl.presentation.states

sealed class PlayPauseButtonState {

    data object Playing : PlayPauseButtonState()

    data object Paused : PlayPauseButtonState()
}