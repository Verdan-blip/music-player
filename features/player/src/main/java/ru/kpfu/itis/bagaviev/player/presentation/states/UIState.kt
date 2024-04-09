package ru.kpfu.itis.bagaviev.player.presentation.states

sealed class UIState {
    data object Initial : UIState()

    data object Ready : UIState()
}