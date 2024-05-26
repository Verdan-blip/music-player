package ru.kpfu.itis.bagaviev.feature.search.impl.presentation.view

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
import ru.kpfu.itis.bagaviev.common.util.typealiases.ViewModelFactories
import ru.kpfu.itis.bagaviev.feature.search.api.domain.playlists.usecase.GetPlaylistDetailsByIdUseCase
import ru.kpfu.itis.bagaviev.feature.search.api.domain.search.usecase.SearchByKeywordsUseCase
import ru.kpfu.itis.bagaviev.feature.search.api.domain.track.usecase.GetTrackDetailsByIdUseCase
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.entities.playlist.mappers.toPlaylistDetailsModel
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.entities.search.mappers.toSearchResultModel
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.entities.track.mappers.toTrackDetailsModel
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.event.DialogEvent
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.state.SearchUiState
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.view.util.toMusicItem
import ru.kpfu.itis.bagaviev.player.api.domain.interactor.MusicPlayerInteractor
import javax.inject.Inject

class SearchViewModel @Inject constructor(
    private val searchByKeywordsUseCase: SearchByKeywordsUseCase,
    private val getTrackDetailsByIdUseCase: GetTrackDetailsByIdUseCase,
    private val getPlaylistDetailsByIdUseCase: GetPlaylistDetailsByIdUseCase,
    private val interactor: MusicPlayerInteractor
) : BaseViewModel() {

    private val _uiState = MutableStateFlow(SearchUiState())
    val uiState: StateFlow<SearchUiState>
        get() = _uiState

    private val _currentPlayingProgressState = MutableStateFlow(0)

    val currentPlayingProgress: StateFlow<Int>
        get() = _currentPlayingProgressState


    private val _dialogEvent = MutableSharedFlow<DialogEvent>()
    val dialogEvent: SharedFlow<DialogEvent>
        get() = _dialogEvent


    private var currentItemDuration: Long = -1

    private var shouldTrackSeekBar: Boolean = true

    init {
        viewModelScope.launch {
            collectPlayerState()
        }
    }

    private suspend fun collectPlayerState() {
        interactor.playerState.collect { state ->

            currentItemDuration = state.currentPlayingItemDuration ?: -1L

            _currentPlayingProgressState.emit(
                state.currentPlayingProgress?.timeAsProgress(currentItemDuration) ?: 0
            )
        }
    }


    fun onSearchQueryChange(text: String) {
        viewModelScope.launch {
            val keywords = text.split("\\s+")
            val searchResult = searchByKeywordsUseCase(keywords)
                .toSearchResultModel()
            _uiState.emit(_uiState.value.copy(
                foundTracks = searchResult.tracks,
                foundPlaylists = searchResult.playlists
            ))
        }
    }

    fun onTrackClick(trackId: Long) {
        viewModelScope.launch {
            if (isPlaying(trackId)) {

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
                currentItemDuration
            ))
        }
    }

    private fun isPlaying(trackId: Long): Boolean {
        /*_uiState.value.playingMusicItem?.id == trackId*/
        return true
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