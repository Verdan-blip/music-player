package ru.kpfu.itis.bagaviev.data.music.api.data.network.track.entities

import ru.kpfu.itis.bagaviev.data.music.api.data.network.user.entity.UserDataEntity
import java.net.URI
import java.util.Date

class TrackDetailsDataEntity(
    val id: Long,
    val title: String,
    val lyrics: String? = null,
    val genre: String,
    val users: List<UserDataEntity>,
    val smallCoverUri: URI,
    val coverUri: URI,
    val audioFileUri: URI,
    val videoFileUri: URI?,
    val releaseDate: Date,
    val playsCount: Int
)