package ru.kpfu.itis.bagaviev.feed.api.domain.feed.entity

import ru.kpfu.itis.bagaviev.feed.api.domain.playlist.entity.Playlist
import ru.kpfu.itis.bagaviev.feed.api.domain.track.entity.Track

data class Feed(
    val chartTracks: List<Track>,
    val popularPlaylists: List<Playlist>
)