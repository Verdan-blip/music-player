package ru.kpfu.itis.bagaviev.feed.impl.presentation.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import ru.kpfu.itis.bagaviev.feed.api.domain.playlists.usecases.GetPlaylistByIdUseCase
import ru.kpfu.itis.bagaviev.feed.api.domain.playlists.usecases.GetPopularPlaylistsUseCase
import ru.kpfu.itis.bagaviev.feed.api.domain.tracks.usecases.GetChartTracksUseCase
import ru.kpfu.itis.bagaviev.feed.api.domain.tracks.usecases.GetTrackDetailsByIdUseCase
import ru.kpfu.itis.bagaviev.feed.impl.FeedRouter
import ru.kpfu.itis.bagaviev.feed.impl.TracksPlaylistsController
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entities.playlists.PlaylistDetailsModel
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entities.playlists.PlaylistModel
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entities.playlists.mappers.toPlaylistModel
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entities.tracks.TrackDetailsModel
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entities.tracks.TrackModel
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entities.tracks.mappers.toTrackDetailsModel
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entities.tracks.mappers.toTrackModel
import ru.kpfu.itis.common.util.extensions.progressAsTime
import ru.kpfu.itis.common.util.extensions.timeAsProgress
import ru.kpfu.itis.common.util.typealiases.ViewModelFactories
import javax.inject.Inject

class FeedViewModel @Inject constructor(
    private val getChartTracksUseCase: GetChartTracksUseCase,
    private val getTrackDetailsByIdUseCase: GetTrackDetailsByIdUseCase,
    private val getPlaylistByIdUseCase: GetPlaylistByIdUseCase,
    private val getPopularPlaylistsUseCase: GetPopularPlaylistsUseCase,
    private val tracksPlaylistsController: TracksPlaylistsController,
    private val feedRouter: FeedRouter
) : ViewModel() {

    private val _chartTracks = MutableStateFlow<List<TrackModel>>(listOf())
    val cartTracks: StateFlow<List<TrackModel>>
        get() = _chartTracks


    private val _popularPlaylists = MutableStateFlow<List<PlaylistModel>>(listOf())
    val popularPlaylists: StateFlow<List<PlaylistModel>>
        get() = _popularPlaylists


    private val _trackDetails = MutableStateFlow<TrackDetailsModel?>(null)
    val trackDetails: StateFlow<TrackDetailsModel?>
        get() = _trackDetails


    private val _playlistDetails = MutableStateFlow<PlaylistDetailsModel?>(null)
    val playlistDetails: StateFlow<PlaylistDetailsModel?>
        get() = _playlistDetails


    val isPlayingState = tracksPlaylistsController.isPlaying

    val currentPlayingTrackId = tracksPlaylistsController.currentTrackId

    val currentPlayingItemProgress = tracksPlaylistsController.currentPlayingItemProgressInMs
        .map { progressInMs ->
            progressInMs?.timeAsProgress(currentPlayingItemDuration.value ?: 0L)
        }

    private val currentPlayingItemDuration = tracksPlaylistsController.currentPlayingItemDuration

    fun onLoadTracks() {
        viewModelScope.launch {
            getChartTracksUseCase().fold(
                onSuccess = { trackResponseList ->
                    _chartTracks.emit(trackResponseList.map { trackResponse ->
                        trackResponse.toTrackModel()
                    })
                },
                onFailure = { }
            )
        }
    }

    fun onLoadPlaylists() {
        viewModelScope.launch {
            getPopularPlaylistsUseCase().fold(
                onSuccess = { playlistList ->
                    _popularPlaylists.emit(
                        playlistList.map { playlist -> playlist.toPlaylistModel() }
                    )
                },
                onFailure = { }
            )
        }
    }

    fun onTrackClick(trackId: Long) {
        viewModelScope.launch {
            if (trackId == currentPlayingTrackId.value) {
                if (isPlayingState.value == true) {
                    tracksPlaylistsController.pause()
                } else {
                    tracksPlaylistsController.play()
                }
            } else {
                onGetTrackDetails(trackId)
                tracksPlaylistsController.playTrack(trackId)
            }
        }
    }

    fun onPlaylistClick(playlistId: Long) {
        viewModelScope.launch {
            tracksPlaylistsController.playPlaylist(playlistId)
        }
    }

    fun onPlayPause() {
        viewModelScope.launch {
            if (isPlayingState.value == true) {
                tracksPlaylistsController.pause()
            } else {
                tracksPlaylistsController.play()
            }
        }
    }

    fun onSeekTo(progress: Int) {
        viewModelScope.launch {
            currentPlayingItemDuration.value?.also { duration ->
                tracksPlaylistsController.seekTo(progress.progressAsTime(duration))
            }
        }
    }

    fun onGetTrackDetails(trackId: Long) {
        viewModelScope.launch {
            _trackDetails.emit(
                getTrackDetailsByIdUseCase(trackId)?.toTrackDetailsModel()
            )
        }
    }

    fun onFloatingTrackClick() {
        feedRouter.navigateToPlayer()
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