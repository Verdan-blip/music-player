package ru.kpfu.itis.bagaviev.feed.api.domain.track.entity

import ru.kpfu.itis.bagaviev.feed.api.domain.author.entity.Author
import java.util.Date

class TrackDetails(
    val id: Long,
    val title: String,
    val genre: String,
    val authors: List<Author>,
    val lyrics: String? = null,
    val smallCoverUri: String,
    val coverUri: String,
    val audioFileUri: String,
    val releaseDate: Date,
    val playsCount: Int,
    val trackClipData: TrackClipData? = null
)