package ru.kpfu.itis.bagaviev.player.impl.presentation.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch
import ru.kpfu.itis.bagaviev.player.api.domain.interactor.MusicControllerInteractor
import ru.kpfu.itis.bagaviev.player.impl.presentation.entities.MusicItemModel
import ru.kpfu.itis.bagaviev.player.impl.presentation.mapper.toMusicItemModel
import ru.kpfu.itis.bagaviev.player.impl.presentation.states.PlayPauseButtonState
import ru.kpfu.itis.bagaviev.player.impl.presentation.util.TimeFormatter
import ru.kpfu.itis.common.util.extensions.progressAsTime
import ru.kpfu.itis.common.util.extensions.timeAsProgress
import ru.kpfu.itis.common.util.typealiases.ViewModelFactories
import javax.inject.Inject

class PlayerViewModel @Inject constructor(
    private val interactor: MusicControllerInteractor
) : ViewModel() {

    private val _playPauseButtonState = MutableStateFlow<PlayPauseButtonState>(
        PlayPauseButtonState.Playing
    )
    val playPauseButtonState: StateFlow<PlayPauseButtonState>
        get() = _playPauseButtonState


    private val _playingTimeState = MutableStateFlow("**:**")
    val playingTimeState: StateFlow<String>
        get() = _playingTimeState


    private val _playingTimeProgressState = MutableStateFlow(0)
    val playingTimeProgressState: StateFlow<Int>
        get() = _playingTimeProgressState


    private val _currentMusicItemState = MutableStateFlow<MusicItemModel?>(null)
    val currentMusicItemState: StateFlow<MusicItemModel?>
        get() = _currentMusicItemState


    private val _currentPlayingItemDuration = MutableStateFlow<Long?>(null)
    val currentPlayingItemDuration: StateFlow<Long?>
        get() = _currentPlayingItemDuration


    private var _shouldStopTrackingProgressing = false

    init {
        viewModelScope.launch {
            launch { collectIsPlaying() }
            launch { collectCurrentMusicItem() }
            launch { collectPlayingTime() }
            launch { collectCurrentPlayingItemDuration() }
        }
    }

    private suspend fun collectIsPlaying() {
        interactor.isPlaying
            .filterNotNull()
            .collect { isPlaying ->
            if (isPlaying) {
                _playPauseButtonState.emit(PlayPauseButtonState.Playing)
            } else {
                _playPauseButtonState.emit(PlayPauseButtonState.Paused)
            }
        }
    }

    private suspend fun collectCurrentMusicItem() {
        interactor.currentMusicItem
            .filterNotNull()
            .collect { musicItem ->
                _currentMusicItemState.emit(
                    musicItem.toMusicItemModel()
                )
            }
    }

    private suspend fun collectCurrentPlayingItemDuration() {
        interactor.currentPlayingItemDuration
            .filterNotNull()
            .collect(_currentPlayingItemDuration::emit)
    }

    private suspend fun collectPlayingTime() {
        interactor.currentPlayingPositionInMs
            .filterNotNull()
            .collect { currentPlayingPositionInMs ->
                if (!_shouldStopTrackingProgressing) {
                    _playingTimeState.emit(
                        TimeFormatter.millisToMmSs(
                            currentPlayingPositionInMs
                        )
                    )
                    _currentPlayingItemDuration.value?.also { duration ->
                        _playingTimeProgressState.emit(
                            currentPlayingPositionInMs.timeAsProgress(duration)
                        )
                    }
                }
            }
    }

    fun onPlayPauseButtonPress() {
        viewModelScope.launch {
            when (_playPauseButtonState.value) {
                is PlayPauseButtonState.Playing -> {
                    interactor.pause()
                }
                is PlayPauseButtonState.Paused -> {
                    interactor.play()
                }
            }
        }
    }

    fun onHoldSeekBarThumb() {
        viewModelScope.launch {
            _shouldStopTrackingProgressing = true
        }
    }

    fun onMoveHeldSeekBarThumb(progress: Int) {
        viewModelScope.launch {
            _currentPlayingItemDuration.value?.also { duration ->
                _playingTimeState.emit(
                    TimeFormatter.millisToMmSs(
                    progress.progressAsTime(duration)
                ))
            }
        }
    }

    fun onReleaseSeekBarThumb(position: Int) {
        viewModelScope.launch {
            _shouldStopTrackingProgressing = false
            _currentPlayingItemDuration.value?.also { duration ->
                interactor.seekTo(position.progressAsTime(duration))
            }
        }
    }

    companion object {

        class Factory @Inject constructor(
            private val viewModelFactories: ViewModelFactories
        ) : ViewModelProvider.Factory {

            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return viewModelFactories.getValue(modelClass).get() as T
            }
        }
    }
}