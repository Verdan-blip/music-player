package ru.kpfu.itis.bagaviev.feature.search.impl.presentation.view

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.kpfu.itis.bagaviev.common.base.BaseViewModel
import ru.kpfu.itis.bagaviev.feature.search.api.domain.playlists.usecase.GetPlaylistDetailsByIdUseCase
import ru.kpfu.itis.bagaviev.feature.search.api.domain.search.usecase.SearchByKeywordsUseCase
import ru.kpfu.itis.bagaviev.feature.search.api.domain.track.usecase.GetTrackDetailsByIdUseCase
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.entities.playlist.PlaylistDetailsModel
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.entities.playlist.mappers.toPlaylistDetailsModel
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.entities.search.mappers.toSearchResultModel
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.entities.track.TrackDetailsModel
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.entities.track.mappers.toTrackDetailsModel
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.event.DialogEvent
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.state.SearchUiState
import ru.kpfu.itis.bagaviev.player.api.domain.interactor.MusicPlayerInteractor
import java.util.LinkedList
import java.util.Queue
import javax.inject.Inject

class SearchViewModel @Inject constructor(
    private val searchByKeywordsUseCase: SearchByKeywordsUseCase,
    private val getTrackDetailsByIdUseCase: GetTrackDetailsByIdUseCase,
    private val getPlaylistDetailsByIdUseCase: GetPlaylistDetailsByIdUseCase,
    private val interactor: MusicPlayerInteractor
) : BaseViewModel() {

    override val coroutineDispatcher: CoroutineDispatcher = Dispatchers.IO


    private val _uiState = MutableStateFlow(SearchUiState())
    val uiState: StateFlow<SearchUiState>
        get() = _uiState


    private val _dialogEvent = MutableSharedFlow<DialogEvent>()
    val dialogEvent: SharedFlow<DialogEvent>
        get() = _dialogEvent


    private val _selectedTrackDetailsEvent = MutableSharedFlow<TrackDetailsModel>()
    val selectedTrackDetailsEvent: SharedFlow<TrackDetailsModel>
        get() = _selectedTrackDetailsEvent


    private val _trackDetailsQueueState = MutableStateFlow<Queue<TrackDetailsModel>>(LinkedList())
    val trackDetailsQueueState: StateFlow<Queue<TrackDetailsModel>>
        get() = _trackDetailsQueueState


    private var trackDetailsModelInCache: TrackDetailsModel? = null


    fun onSearchQueryChange(text: String) {
        if (text.isBlank()) return

        viewModelScope.launch {
            val keywords = text.split("\\s+")
            searchByKeywordsUseCase(keywords).fold(
                onSuccess = { searchResult ->
                    val searchResultModel = searchResult.toSearchResultModel()
                    _uiState.emit(
                        _uiState.value.copy(
                            foundTracks = searchResultModel.tracks,
                            foundPlaylists = searchResultModel.playlists
                        )
                    )
                },
                onFailure = { throwable ->
                    showAlert(throwable.message.toString())
                }
            )
        }
    }

    fun onTrackClick(trackId: Long) {
        viewModelScope.launch {
            if (trackDetailsModelInCache?.id != trackId) {
                loadTrackDetails(trackId)?.also { trackDetailsModel ->
                    _selectedTrackDetailsEvent.emit(trackDetailsModel)
                    _uiState.emit(_uiState.value.copy(
                        backgroundUri = trackDetailsModel.coverUri)
                    )
                    trackDetailsModelInCache = trackDetailsModel
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

    fun onPlaylistLongClick(playlistId: Long) {
        viewModelScope.launch {
            loadPlaylistDetails(playlistId)?.also { playlistDetailsModel ->
                _dialogEvent.emit(DialogEvent.PlaylistDetails(playlistDetailsModel))
            }
        }
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