package ru.kpfu.itis.bagaviev.feature.profile.domain.entity.track

class MyTrack(
    val id: Long,
    val title: String,
    val authors: List<String>,
    val smallCoverUri: String
)