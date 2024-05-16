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
import ru.kpfu.itis.bagaviev.feed.api.domain.playlist.usecases.GetPlaylistDetailsByIdUseCase
import ru.kpfu.itis.bagaviev.feed.api.domain.playlist.usecases.GetPopularPlaylistsUseCase
import ru.kpfu.itis.bagaviev.feed.api.domain.track.usecase.GetPopularTracksUseCase
import ru.kpfu.itis.bagaviev.feed.api.domain.track.usecase.GetTrackDetailsByIdUseCase
import ru.kpfu.itis.bagaviev.feed.impl.FeedRouter
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entities.playlists.mappers.toPlaylistDetailsModel
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entities.playlists.mappers.toPlaylistModel
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entities.tracks.mappers.toTrackDetailsModel
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entities.tracks.mappers.toTrackModel
import ru.kpfu.itis.bagaviev.feed.impl.presentation.view.state.DialogState
import ru.kpfu.itis.bagaviev.feed.impl.presentation.view.state.FeedUiState
import ru.kpfu.itis.bagaviev.feed.impl.presentation.view.util.toMusicItem
import ru.kpfu.itis.bagaviev.player.api.domain.entities.PlayerCallback
import ru.kpfu.itis.bagaviev.player.api.domain.interactor.MusicPlayerInteractor
import javax.inject.Inject

class FeedViewModel @Inject constructor(
    private val getPopularTracksUseCase: GetPopularTracksUseCase,
    private val getTrackDetailsByIdUseCase: GetTrackDetailsByIdUseCase,
    private val getPlaylistDetailsByIdUseCase: GetPlaylistDetailsByIdUseCase,
    private val getPopularPlaylistsUseCase: GetPopularPlaylistsUseCase,
    private val interactor: MusicPlayerInteractor,
    private val feedRouter: FeedRouter
) : BaseViewModel() {

    private val _uiState = MutableStateFlow(FeedUiState())
    val uiState: StateFlow<FeedUiState>
        get() = _uiState


    private val _dialogState = MutableSharedFlow<DialogState>()
    val dialogState: SharedFlow<DialogState>
        get() = _dialogState


    private val _currentPlayingProgressState = MutableStateFlow(0)

    val currentPlayingProgressState: StateFlow<Int>
        get() = _currentPlayingProgressState


    private var currentItemDuration: Long = -1

    private var shouldTrackSeekBar: Boolean = true

    init {
        viewModelScope.launch {
            loadTracks()
            loadPlaylists()
            collectPlayerState()
        }
    }

    private suspend fun collectPlayerState() {
        interactor.playerCallback.collect { callback ->
            when (callback) {
                is PlayerCallback.PlayerInitialized -> Unit
                is PlayerCallback.ItemDurationChanged -> {
                    currentItemDuration = callback.duration
                }
                is PlayerCallback.MusicItemChanged -> {
                    _uiState.emit(_uiState.value.copy(
                        playingMusicItem = callback.musicItem,
                        background = callback.musicItem.coverUri.toUri()
                    ))
                }
                is PlayerCallback.PlayingPositionChanged -> {
                    if (shouldTrackSeekBar) {
                        _currentPlayingProgressState.emit(
                            callback.positionInMs.timeAsProgress(currentItemDuration)
                        )
                    }
                }
                is PlayerCallback.IsPlayingChanged -> {
                    _uiState.emit(
                        _uiState.value.copy(
                            isPlaying = callback.isPlaying
                        )
                    )
                }
            }
        }
    }

    private suspend fun loadTracks() {
        getPopularTracksUseCase().fold(
            onSuccess = { trackResponseList ->
                _uiState.emit(_uiState.value.copy(
                    popularTracks = trackResponseList.map { track ->
                        track.toTrackModel()
                    }
                ))
            },
            onFailure = { throwable ->
                showAlert(throwable.message.toString())
            }
        )
    }

    private suspend fun loadPlaylists() {
        getPopularPlaylistsUseCase().fold(
            onSuccess = { playlistList ->
                _uiState.emit(_uiState.value.copy(
                    popularPlaylists = playlistList.map { playlist ->
                        playlist.toPlaylistModel()
                    }
                ))
            },
            onFailure = { throwable ->
                showAlert(throwable.message.toString())
            }
        )
    }

    fun onTrackClick(trackId: Long) {
        viewModelScope.launch {
            if (isPlaying(trackId)) {
                if (_uiState.value.isPlaying) {
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
                _dialogState.emit(
                    DialogState.TrackDetails(trackDetailsModel)
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
                _dialogState.emit(
                    DialogState.PlaylistDetails(playlistDetailsModel)
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
                currentItemDuration
            ))
        }
    }

    fun onFloatingTrackClick() {
        feedRouter.navigateToPlayer()
    }

    private fun isPlaying(trackId: Long): Boolean =
        _uiState.value.playingMusicItem?.id == trackId


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