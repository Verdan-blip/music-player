package ru.kpfu.itis.bagaviev.data.music.api.data.local.music.entity

class DownloadedTrackDataEntity(
    val id: Long,
    val title: String,
    val usersNames: List<String>,
    val smallCoverUri: String,
    val audioUri: String
)