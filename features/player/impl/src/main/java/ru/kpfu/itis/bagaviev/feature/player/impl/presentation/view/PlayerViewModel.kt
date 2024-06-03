package ru.kpfu.itis.bagaviev.feature.player.impl.presentation.view

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.kpfu.itis.bagaviev.common.util.extensions.progressAsTime
import ru.kpfu.itis.bagaviev.common.util.extensions.timeAsProgress
import ru.kpfu.itis.bagaviev.feature.player.impl.presentation.states.PlayerUiState
import ru.kpfu.itis.bagaviev.feature.player.impl.presentation.util.TimeFormatter
import ru.kpfu.itis.bagaviev.player.api.domain.interactor.MusicPlayerInteractor
import javax.inject.Inject

class PlayerViewModel @Inject constructor(
    private val interactor: MusicPlayerInteractor
) : ViewModel() {

    private val _uiState = MutableStateFlow(PlayerUiState())

    val uiState: StateFlow<PlayerUiState>
        get() = _uiState

    private val _currentProgressState = MutableStateFlow(0)

    val currentProgressState: StateFlow<Int>
        get() = _currentProgressState


    private val _currentProgressTimeState = MutableStateFlow("00:00")

    val currentProgressTimeState: StateFlow<String>
        get() = _currentProgressTimeState


    private val _currentPlayingVideoState = MutableStateFlow<Uri?>(null)

    val currentPlayingVideoState: StateFlow<Uri?>
        get() = _currentPlayingVideoState


    private var shouldStopTrackingProgress = false

    private var currentPlayingDuration: Long = -1

    init {
        viewModelScope.launch {
            collectPlayerState()
        }
    }

    private suspend fun collectPlayerState() {
        interactor.playerState.collect { state ->

            state.currentPlayingItemDuration?.also { duration ->
                currentPlayingDuration = duration
            }

            if (!shouldStopTrackingProgress) {
                state.currentPlayingProgress?.also { progressInMs->
                    _currentProgressState.emit(
                        progressInMs.timeAsProgress(currentPlayingDuration)
                    )
                    _currentProgressTimeState.emit(
                        TimeFormatter.millisToMmSs(progressInMs)
                    )
                }
            }

            state.currentMusicItem?.apply {
                _uiState.emit(
                    _uiState.value.copy(
                        title = title,
                        coverUri = coverUri,
                        isPlaying = state.isPlaying ?: false
                    )
                )
            }
        }
    }

    fun onPlayPauseButtonClick() {
        viewModelScope.launch {
            if (_uiState.value.isPlaying)
                interactor.pause()
            else
                interactor.play()
        }
    }

    fun onMoveHeldSeekBarThumb(progress: Int) {
        viewModelScope.launch {
            _currentProgressTimeState.emit(
                TimeFormatter.millisToMmSs(progress.progressAsTime(currentPlayingDuration))
            )
        }
    }

    fun onSeekTo(progress: Int) {
        viewModelScope.launch {
            shouldStopTrackingProgress = false
            interactor.seekTo(progress.progressAsTime(currentPlayingDuration))
        }
    }
}