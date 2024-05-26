package ru.kpfu.itis.bagaviev.feature.search.api.domain.search.entity

import ru.kpfu.itis.bagaviev.feature.search.api.domain.playlists.entity.Playlist
import ru.kpfu.itis.bagaviev.feature.search.api.domain.track.entity.Track
import ru.kpfu.itis.bagaviev.feature.search.api.domain.author.entity.Author

class SearchResult(
    val authors: List<Author>,
    val tracks: List<Track>,
    val playlists: List<Playlist>
)