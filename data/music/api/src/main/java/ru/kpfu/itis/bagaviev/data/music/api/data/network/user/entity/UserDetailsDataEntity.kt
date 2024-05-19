package ru.kpfu.itis.bagaviev.data.music.api.data.network.user.entity

import ru.kpfu.itis.bagaviev.data.music.api.data.network.playlist.entity.PlaylistDataEntity
import ru.kpfu.itis.bagaviev.data.music.api.data.network.track.entity.TrackDataEntity
import java.net.URI

class UserDetailsDataEntity(
    val id: Long,
    val login: String,
    val avatarUri: URI?,
    val tracks: List<TrackDataEntity>,
    val playlists: List<PlaylistDataEntity>
)