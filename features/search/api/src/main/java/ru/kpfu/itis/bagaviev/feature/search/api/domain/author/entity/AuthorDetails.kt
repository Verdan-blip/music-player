package ru.kpfu.itis.bagaviev.feature.search.api.domain.author.entity

import ru.kpfu.itis.bagaviev.feature.search.api.domain.playlists.entity.Playlist
import ru.kpfu.itis.bagaviev.feature.search.api.domain.track.entity.Track
import java.net.URI

class AuthorDetails(
    val id: Long,
    val login: String,
    val avatarUri: URI,
    val tracks: List<Track>,
    val playlists: List<Playlist>
)