package ru.kpfu.itis.bagaviev.data.music.api.data.network.playlist.entity

import ru.kpfu.itis.bagaviev.data.music.api.data.network.track.entity.TrackDataEntity
import ru.kpfu.itis.bagaviev.data.music.api.data.network.user.entity.UserDataEntity
import java.net.URI

class PlaylistDataEntity(
    val id: Long,
    val title: String,
    val coverUri: URI,
    val user: UserDataEntity,
    val tracks: List<TrackDataEntity>
)