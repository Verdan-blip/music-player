package ru.kpfu.itis.bagaviev.feature.search.api.domain.track.entity

class Track(
    val id: Long,
    val title: String,
    val authorNames: List<String>,
    val smallCoverUri: String
)