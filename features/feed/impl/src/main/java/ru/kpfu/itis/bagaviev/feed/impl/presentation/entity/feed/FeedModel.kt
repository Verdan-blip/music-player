package ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.feed

import ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.playlist.PlaylistModel
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.track.TrackModel

data class FeedModel(
    val chartTracks: List<TrackModel>,
    val popularPlaylists: List<PlaylistModel>
)