package ru.kpfu.itis.bagaviev.data.music.api.data.network.track.entity

import ru.kpfu.itis.bagaviev.data.music.api.data.network.user.entity.UserDataEntity
import java.net.URI

class TrackDataEntity(
    val id: Long,
    val title: String,
    val users: List<UserDataEntity>,
    val smallCoverUri: URI
)