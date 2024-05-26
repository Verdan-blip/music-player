package ru.kpfu.itis.bagaviev.feature.search.api.domain.playlists.entity

import ru.kpfu.itis.bagaviev.feature.search.api.domain.author.entity.Author
import ru.kpfu.itis.bagaviev.feature.search.api.domain.track.entity.Track
import java.util.Date

class PlaylistDetails(
    val id: Long,
    val title: String,
    val author: Author,
    val coverUri: String,
    val tracks: List<Track>,
    val createdDate: Date,
    val playsCount: Int
)