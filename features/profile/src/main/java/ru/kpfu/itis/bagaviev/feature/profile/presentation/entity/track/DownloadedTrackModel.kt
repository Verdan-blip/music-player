package ru.kpfu.itis.bagaviev.feature.profile.presentation.entity.track

class DownloadedTrackModel(
    val id: Long,
    val title: String,
    val authors: List<String>,
    val smallCoverUri: String,
    val audioUri: String
)