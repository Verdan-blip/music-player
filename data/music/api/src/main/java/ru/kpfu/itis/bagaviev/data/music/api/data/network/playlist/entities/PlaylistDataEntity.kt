package ru.kpfu.itis.bagaviev.data.music.api.data.network.playlist.entities

import ru.kpfu.itis.bagaviev.data.music.api.data.network.track.entities.TrackDataEntity
import ru.kpfu.itis.bagaviev.data.music.api.data.network.user.entity.UserDataEntity
import java.net.URI

class PlaylistDataEntity(
    val id: Long,
    val title: String,
    val coverUri: URI,
    val user: UserDataEntity,
    val tracks: List<TrackDataEntity>
)