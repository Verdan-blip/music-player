package ru.kpfu.itis.bagaviev.feed.impl.presentation.view

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.kpfu.itis.bagaviev.common.base.BaseViewModel
import ru.kpfu.itis.bagaviev.feed.api.domain.feed.usecase.GetFeedUseCase
import ru.kpfu.itis.bagaviev.feed.api.domain.playlist.usecases.GetPlaylistDetailsByIdUseCase
import ru.kpfu.itis.bagaviev.feed.api.domain.track.usecase.GetTrackDetailsByIdUseCase
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.feed.mapper.toFeedModel
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.playlist.PlaylistDetailsModel
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.playlist.mapper.toPlaylistDetailsModel
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.track.TrackDetailsModel
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.track.mapper.toTrackDetailsModel
import ru.kpfu.itis.bagaviev.feed.impl.presentation.event.DialogEvent
import ru.kpfu.itis.bagaviev.feed.impl.presentation.state.FeedUiState
import java.util.LinkedList
import java.util.Queue
import javax.inject.Inject

class FeedViewModel @Inject constructor(
    private val getTrackDetailsByIdUseCase: GetTrackDetailsByIdUseCase,
    private val getPlaylistDetailsByIdUseCase: GetPlaylistDetailsByIdUseCase,
    private val getFeedUseCase: GetFeedUseCase
) : BaseViewModel() {

    override val coroutineDispatcher: CoroutineDispatcher = Dispatchers.IO


    private val _uiState = MutableStateFlow(FeedUiState())
    val uiState: StateFlow<FeedUiState>
        get() = _uiState


    private val _dialogEvent = MutableSharedFlow<DialogEvent>()
    val dialogEvent: SharedFlow<DialogEvent>
        get() = _dialogEvent


    private val _selectedTrackDetailsEvent = MutableSharedFlow<TrackDetailsModel>()
    val selectedTrackDetailsEvent: SharedFlow<TrackDetailsModel>
        get() = _selectedTrackDetailsEvent


    private val _selectedTrackDetailsToDownloadEvent = MutableSharedFlow<TrackDetailsModel>()
    val selectedTrackDetailsToDownloadEvent: SharedFlow<TrackDetailsModel>
        get() = _selectedTrackDetailsToDownloadEvent


    private val _trackDetailsQueueState = MutableStateFlow<Queue<TrackDetailsModel>>(LinkedList())
    val trackDetailsQueueState: StateFlow<Queue<TrackDetailsModel>>
        get() = _trackDetailsQueueState

    private var trackDetailsModelInCache: TrackDetailsModel? = null


    init {
        viewModelScope.launch {
            loadFeed()
        }
    }

    fun onTrackClick(trackId: Long) {
        viewModelScope.launch {
            if (trackDetailsModelInCache?.id != trackId) {
                loadTrackDetails(trackId)?.also { trackDetailModel ->
                    _selectedTrackDetailsEvent.emit(trackDetailModel)
                    _uiState.emit(_uiState.value.copy(
                        backgroundUri = trackDetailModel.coverUri)
                    )
                    trackDetailsModelInCache = trackDetailModel
                }
            }
        }
    }

    fun onTrackLongClick(trackId: Long) {
        viewModelScope.launch {
            trackDetailsModelInCache = if (trackDetailsModelInCache?.id != trackId) {
                loadTrackDetails(trackId)
            } else {
                trackDetailsModelInCache
            }
            trackDetailsModelInCache?.also { trackDetails ->
                _dialogEvent.emit(DialogEvent.TrackDetails(trackDetails))
            }
        }
    }

    fun onPlaylistClick(playlistId: Long) {
        viewModelScope.launch {
            loadPlaylistDetails(playlistId)?.also { playlistDetailsModel ->
                val tracksDetailsQueue: Queue<TrackDetailsModel> = LinkedList()
                playlistDetailsModel.tracks.forEachIndexed { index, trackModel ->
                    loadTrackDetails(trackModel.id)?.also { trackDetailsModel ->
                        if (index == 0) {
                            _selectedTrackDetailsEvent.emit(trackDetailsModel)
                        } else {
                            tracksDetailsQueue.add(trackDetailsModel)
                        }
                    }
                }
                _trackDetailsQueueState.emit(tracksDetailsQueue)
            }
        }
    }

    fun onDownloadTrackClick(trackId: Long) {
        viewModelScope.launch {
            val trackDetails = if (trackDetailsModelInCache?.id != trackId) {
                loadTrackDetails(trackId)
            } else {
                trackDetailsModelInCache
            }
            trackDetails?.also { trackDetailsModel ->
                _selectedTrackDetailsToDownloadEvent.emit(trackDetailsModel)
            }
        }
    }

    fun onPlaylistLongClick(playlistId: Long) {
        viewModelScope.launch {
            loadPlaylistDetails(playlistId)?.also { playlistDetailsModel ->
                _dialogEvent.emit(DialogEvent.PlaylistDetails(playlistDetailsModel))
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

    private suspend fun loadTrackDetails(trackId: Long): TrackDetailsModel? =
        getTrackDetailsByIdUseCase(trackId)
            .onFailure { throwable ->
                showAlert(throwable.message.toString())
            }
            .map { trackDetails -> trackDetails?.toTrackDetailsModel() }
            .getOrNull()

    private suspend fun loadPlaylistDetails(playlistId: Long): PlaylistDetailsModel? =
        getPlaylistDetailsByIdUseCase(playlistId)
            .onFailure { throwable ->
                showAlert(throwable.message.toString())
            }
            .map { playlistDetails -> playlistDetails?.toPlaylistDetailsModel() }
            .getOrNull()
}