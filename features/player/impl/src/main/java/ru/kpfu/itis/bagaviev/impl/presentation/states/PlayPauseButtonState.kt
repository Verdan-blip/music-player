package ru.kpfu.itis.bagaviev.impl.presentation.states

sealed class PlayPauseButtonState {

    data object Playing : PlayPauseButtonState()

    data object Paused : PlayPauseButtonState()
}