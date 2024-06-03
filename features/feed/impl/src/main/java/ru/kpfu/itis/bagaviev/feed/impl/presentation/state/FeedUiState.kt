package ru.kpfu.itis.bagaviev.feed.impl.presentation.state

import ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.playlist.PlaylistModel
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.track.TrackModel

data class FeedUiState(
    val backgroundUri: String? = null,
    val popularTracks: List<TrackModel> = listOf(),
    val popularPlaylists: List<PlaylistModel> = listOf()
)