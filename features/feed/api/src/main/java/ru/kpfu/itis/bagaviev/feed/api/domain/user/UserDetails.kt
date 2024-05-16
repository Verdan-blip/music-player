package ru.kpfu.itis.bagaviev.feed.api.domain.user

import ru.kpfu.itis.bagaviev.feed.api.domain.playlist.entity.Playlist
import ru.kpfu.itis.bagaviev.feed.api.domain.track.entity.Track

class UserDetails(

    val id: Long,

    val login: String,

    val avatarUri: String,

    val tracks: List<Track>,

    val playlists: List<Playlist>
)