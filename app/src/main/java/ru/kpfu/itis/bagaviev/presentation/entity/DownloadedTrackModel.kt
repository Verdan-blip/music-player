package ru.kpfu.itis.bagaviev.presentation.entity

class DownloadedTrackModel(
    val id: Long,
    val title: String,
    val users: List<String>,
    val smallCoverUri: String,
    val audiUri: String
)