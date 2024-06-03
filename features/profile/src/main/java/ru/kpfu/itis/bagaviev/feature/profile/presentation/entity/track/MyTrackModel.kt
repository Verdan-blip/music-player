package ru.kpfu.itis.bagaviev.feature.profile.presentation.entity.track

class MyTrackModel(
    val id: Long,
    val title: String,
    val authors: List<String>,
    val smallCoverUri: String
)