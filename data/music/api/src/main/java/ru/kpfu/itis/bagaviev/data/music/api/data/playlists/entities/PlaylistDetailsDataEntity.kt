package ru.kpfu.itis.bagaviev.data.music.api.data.playlists.entities

import ru.kpfu.itis.bagaviev.data.music.api.data.tracks.entities.TrackDataEntity
import ru.kpfu.itis.bagaviev.data.music.api.data.users.entities.UserDataEntity
import java.net.URI
import java.util.Date

class PlaylistDetailsDataEntity(
    val id: Long,
    val title: String,
    val coverUri: URI,
    val user: UserDataEntity,
    val tracks: List<TrackDataEntity>,
    val createdDate: Date,
    val playsCount: Int
)