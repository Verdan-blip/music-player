package ru.kpfu.itis.bagaviev.feature.search.impl.presentation.state

import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.entities.playlist.PlaylistModel
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.entities.track.TrackModel

data class SearchUiState(
    val foundTracks: List<TrackModel> = listOf(),
    val foundPlaylists: List<PlaylistModel> = listOf(),
    val backgroundUri: String? = null
)