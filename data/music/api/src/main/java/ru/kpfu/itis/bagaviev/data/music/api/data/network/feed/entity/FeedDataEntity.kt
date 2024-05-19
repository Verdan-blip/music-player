package ru.kpfu.itis.bagaviev.data.music.api.data.network.feed.entity

import ru.kpfu.itis.bagaviev.data.music.api.data.network.playlist.entity.PlaylistDataEntity
import ru.kpfu.itis.bagaviev.data.music.api.data.network.track.entity.TrackDataEntity

data class FeedDataEntity(
    val chartTracks: List<TrackDataEntity>,
    val popularPlaylists: List<PlaylistDataEntity>
)