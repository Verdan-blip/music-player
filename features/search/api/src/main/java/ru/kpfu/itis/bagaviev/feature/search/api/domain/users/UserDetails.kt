package ru.kpfu.itis.bagaviev.feature.search.api.domain.users

import ru.kpfu.itis.bagaviev.feature.search.api.domain.playlists.entites.Playlist
import ru.kpfu.itis.bagaviev.feature.search.api.domain.tracks.entites.Track
import java.net.URI

class UserDetails(
    val id: Long,
    val login: String,
    val avatarUri: URI,
    val tracks: List<Track>,
    val playlists: List<Playlist>
)