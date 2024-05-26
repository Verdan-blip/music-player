package ru.kpfu.itis.bagaviev.feed.impl.presentation.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.kpfu.itis.bagaviev.common.base.BaseViewModel
import ru.kpfu.itis.bagaviev.common.util.extensions.progressAsTime
import ru.kpfu.itis.bagaviev.common.util.extensions.timeAsProgress
import ru.kpfu.itis.bagaviev.common.util.extensions.toUri
import ru.kpfu.itis.bagaviev.common.util.typealiases.ViewModelFactories
import ru.kpfu.itis.bagaviev.feed.api.domain.feed.usecase.GetFeedUseCase
import ru.kpfu.itis.bagaviev.feed.api.domain.playlist.usecases.GetPlaylistDetailsByIdUseCase
import ru.kpfu.itis.bagaviev.feed.api.domain.track.usecase.GetTrackDetailsByIdUseCase
import ru.kpfu.itis.bagaviev.feed.impl.FeedRouter
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.feed.mapper.toFeedModel
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.playlist.mapper.toPlaylistDetailsModel
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.track.TrackModel
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.track.mapper.toTrackDetailsModel
import ru.kpfu.itis.bagaviev.feed.impl.presentation.event.DialogEvent
import ru.kpfu.itis.bagaviev.feed.impl.presentation.state.FeedUiState
import ru.kpfu.itis.bagaviev.feed.impl.presentation.view.recyclerview.mapper.toTrackModel
import ru.kpfu.itis.bagaviev.feed.impl.presentation.view.util.toMusicItem
import ru.kpfu.itis.bagaviev.player.api.domain.entities.PlayerCallback
import ru.kpfu.itis.bagaviev.player.api.domain.interactor.MusicPlayerInteractor
import javax.inject.Inject

class FeedViewModel @Inject constructor(
    private val getTrackDetailsByIdUseCase: GetTrackDetailsByIdUseCase,
    private val getPlaylistDetailsByIdUseCase: GetPlaylistDetailsByIdUseCase,
    private val getFeedUseCase: GetFeedUseCase,
    private val interactor: MusicPlayerInteractor,
    private val feedRouter: FeedRouter
) : BaseViewModel() {

    private val _currentPlayingItemDuration = MutableStateFlow(
        interactor.playerState.value.currentPlayingItemDuration ?: 0L
    )

    private val _uiState = MutableStateFlow(FeedUiState())
    val uiState: StateFlow<FeedUiState>
        get() = _uiState


    private val _dialogEvent = MutableSharedFlow<DialogEvent>()
    val dialogEvent: SharedFlow<DialogEvent>
        get() = _dialogEvent


    private val _currentPlayingProgressState = MutableStateFlow(
        interactor.playerState.value.currentPlayingProgress
            ?.timeAsProgress(_currentPlayingItemDuration.value) ?: 0
    )

    val currentPlayingProgressState: StateFlow<Int>
        get() = _currentPlayingProgressState


    private val _currentIsPlayingState = MutableStateFlow(
        interactor.playerState.value.isPlaying ?: false
    )

    val currentIsPlayingState: StateFlow<Boolean>
        get() = _currentIsPlayingState


    private val _currentPlayingTrackModelState = MutableStateFlow(
        interactor.playerState.value.currentMusicItem?.toTrackModel()
    )

    val currentPlayingTrackModelState: StateFlow<TrackModel?>
        get() = _currentPlayingTrackModelState


    private var shouldTrackSeekBar: Boolean = true


    init {
        viewModelScope.launch {
            launch { loadFeed() }
            launch { collectPlayerCallbacks() }
        }
    }

    private suspend fun collectPlayerCallbacks() {
        interactor.playerCallback.collect { callback ->
            when (callback) {
                is PlayerCallback.PlayerInitializing -> Unit
                is PlayerCallback.ItemDurationChanged -> {
                    _currentPlayingItemDuration.emit(callback.duration)
                }
                is PlayerCallback.MusicItemChanged -> {
                    callback.musicItem.apply {
                        _currentPlayingTrackModelState.emit(toTrackModel())
                        _uiState.emit(_uiState.value.copy(background = coverUri.toUri()))
                    }
                }
                is PlayerCallback.PlayingPositionChanged -> {
                    if (shouldTrackSeekBar) {
                        _currentPlayingProgressState.emit(
                            callback.positionInMs.timeAsProgress(
                                _currentPlayingItemDuration.value
                            )
                        )
                    }
                }
                is PlayerCallback.IsPlayingChanged -> {
                    _currentIsPlayingState.emit(
                        callback.isPlaying
                    )
                }
            }
        }
    }

    private suspend fun loadFeed() {
        getFeedUseCase().fold(
            onSuccess = { feed ->
                val feedModel = feed.toFeedModel()
                _uiState.emit(
                    _uiState.value.copy(
                        popularTracks = feedModel.chartTracks,
                        popularPlaylists = feedModel.popularPlaylists
                    )
                )
            },
            onFailure = { throwable ->
                showAlert(throwable.message.toString())
            },
        )
    }

    fun onTrackClick(trackId: Long) {
        viewModelScope.launch {
            if (isPlaying(trackId)) {
                if (_currentIsPlayingState.value) {
                    interactor.pause()
                } else {
                    interactor.play()
                }
            } else {
                getTrackDetailsByIdUseCase(trackId)?.also { trackDetails ->
                    val trackDetailsModel = trackDetails.toTrackDetailsModel()
                    interactor.play(trackDetailsModel.toMusicItem())
                }
            }
        }
    }

    fun onTrackLongClick(trackId: Long) {
        viewModelScope.launch {
            getTrackDetailsByIdUseCase(trackId)?.also { trackDetails ->
                val trackDetailsModel = trackDetails.toTrackDetailsModel()
                _dialogEvent.emit(
                    DialogEvent.TrackDetails(trackDetailsModel)
                )
            }
        }
    }

    fun onPlaylistClick(playlistId: Long) {
        viewModelScope.launch {
            getPlaylistDetailsByIdUseCase(playlistId)?.also { playlistDetails ->
                val playlistDetailsModel = playlistDetails.toPlaylistDetailsModel()
                playlistDetailsModel.tracks.forEachIndexed { index, trackModel ->
                    getTrackDetailsByIdUseCase(trackModel.id)?.also { trackDetails ->
                        val trackDetailsModel = trackDetails.toTrackDetailsModel()
                        val musicItem = trackDetailsModel.toMusicItem()
                        if (index == 0) {
                            interactor.play(musicItem)
                        } else {
                            interactor.add(musicItem)
                        }
                    }
                }
            }
        }
    }

    fun onPlaylistLongClick(playlistId: Long) {
        viewModelScope.launch {
            getPlaylistDetailsByIdUseCase(playlistId)?.also { trackDetails ->
                val playlistDetailsModel = trackDetails.toPlaylistDetailsModel()
                _dialogEvent.emit(
                    DialogEvent.PlaylistDetails(playlistDetailsModel)
                )
            }
        }
    }

    fun onMoveHeldSeekBar(progress: Int) {
        viewModelScope.launch {
            shouldTrackSeekBar = false
        }
    }

    fun onSeekTo(progress: Int) {
        viewModelScope.launch {
            shouldTrackSeekBar = true
            interactor.seekTo(progress.progressAsTime(
                _currentPlayingItemDuration.value
            ))
        }
    }

    fun onFloatingTrackClick() {
        feedRouter.navigateToPlayer()
    }

    private fun isPlaying(trackId: Long): Boolean =
        _currentPlayingTrackModelState.value?.id == trackId


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