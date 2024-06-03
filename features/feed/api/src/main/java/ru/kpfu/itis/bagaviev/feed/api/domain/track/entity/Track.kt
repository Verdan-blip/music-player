package ru.kpfu.itis.bagaviev.feed.api.domain.track.entity

class Track(
    val id: Long,
    val title: String,
    val authorsNames: List<String>,
    val smallCoverUri: String
)