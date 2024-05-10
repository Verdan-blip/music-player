package ru.kpfu.itis.bagaviev.data.music.api.data.tracks.entities

import ru.kpfu.itis.bagaviev.data.music.api.data.users.entities.UserDataEntity
import java.net.URI

class TrackDataEntity(
    val id: Long,
    val title: String,
    val users: List<UserDataEntity>,
    val smallCoverUri: URI
)