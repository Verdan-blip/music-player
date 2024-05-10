package ru.kpfu.itis.bagaviev.feature.search.api.domain.search.entities

import ru.kpfu.itis.bagaviev.feature.search.api.domain.playlists.entites.Playlist
import ru.kpfu.itis.bagaviev.feature.search.api.domain.tracks.entites.Track
import ru.kpfu.itis.bagaviev.feature.search.api.domain.users.User

class SearchResult(
    val users: List<User>,
    val tracks: List<Track>,
    val playlists: List<Playlist>
)