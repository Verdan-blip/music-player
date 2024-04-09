package ru.kpfu.itis.bagaviev.player.presentation.view

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.kpfu.itis.bagaviev.player.presentation.states.UIMusicEvent
import ru.kpfu.itis.bagaviev.player.presentation.states.UIState
import javax.inject.Inject

class PlayerViewModel @Inject constructor(
) : ViewModel() {

    private val _uiState = MutableStateFlow(UIState.Initial)
    val uiState: StateFlow<UIState>
        get() = _uiState

    private val _uiMusicEvent = MutableStateFlow(UIMusicEvent.PlayPause)
    val uiMusicEvent: StateFlow<UIMusicEvent>
        get() = _uiMusicEvent

    fun onUIMusicEvent(uiMusicEvent: UIMusicEvent) {

    }
}