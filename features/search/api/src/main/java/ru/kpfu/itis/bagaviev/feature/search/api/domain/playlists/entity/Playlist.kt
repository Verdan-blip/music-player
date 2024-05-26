package ru.kpfu.itis.bagaviev.feature.search.api.domain.playlists.entity

import ru.kpfu.itis.bagaviev.feature.search.api.domain.track.entity.Track
import ru.kpfu.itis.bagaviev.feature.search.api.domain.author.entity.Author
import java.net.URI

class Playlist(
    val id: Long,
    val title: String,
    val coverUri: String,
    val author: Author,
    val tracks: List<Track>
)