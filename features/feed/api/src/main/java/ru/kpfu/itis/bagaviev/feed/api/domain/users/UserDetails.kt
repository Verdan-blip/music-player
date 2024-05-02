package ru.kpfu.itis.bagaviev.feed.api.domain.users

import ru.kpfu.itis.bagaviev.feed.api.domain.playlists.entites.Playlist
import ru.kpfu.itis.bagaviev.feed.api.domain.tracks.entites.Track

class UserDetails(

    val id: Long,

    val login: String,

    val avatarUri: String,

    val tracks: List<Track>,

    val playlists: List<Playlist>
)