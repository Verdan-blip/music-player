package ru.kpfu.itis.bagaviev.impl.presentation.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.kpfu.itis.bagaviev.feed.domain.playlists.entites.responses.PlaylistResponseModel
import ru.kpfu.itis.bagaviev.feed.domain.tracks.entites.responses.TrackResponseModel
import ru.kpfu.itis.bagaviev.impl.presentation.entities.tracks.mappers.toTrackResponseModel
import javax.inject.Inject

class FeedViewModel @Inject constructor(
    private val getChartTracksUseCase: ru.kpfu.itis.bagaviev.api.domain.tracks.usecases.GetChartTracksUseCase
) : ViewModel() {

    private val _tracksResponse = MutableStateFlow<List<TrackResponseModel>>(listOf())
    val tracksResponse: StateFlow<List<TrackResponseModel>>
        get() = _tracksResponse

    private val _playlistsResponse = MutableStateFlow<List<PlaylistResponseModel>>(listOf())
    val playlistsResponse: StateFlow<List<PlaylistResponseModel>>
        get() = _playlistsResponse

    fun onLoadTracks() {
        viewModelScope.launch {
            getChartTracksUseCase().fold(
                onSuccess = { trackResponseList ->
                    _tracksResponse.emit(trackResponseList.map { trackResponse ->
                        trackResponse.toTrackResponseModel()
                    })
                },
                onFailure = { throwable ->

                }
            )
        }
    }
}