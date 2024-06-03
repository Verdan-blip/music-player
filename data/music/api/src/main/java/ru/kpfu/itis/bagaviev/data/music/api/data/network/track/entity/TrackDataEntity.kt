package ru.kpfu.itis.bagaviev.data.music.api.data.network.track.entity

class TrackDataEntity(
    val id: Long,
    val title: String,
    val usersNames: List<String>,
    val smallCoverUri: String
)