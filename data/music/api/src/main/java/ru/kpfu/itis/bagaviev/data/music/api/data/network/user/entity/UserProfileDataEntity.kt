package ru.kpfu.itis.bagaviev.data.music.api.data.network.user.entity

import ru.kpfu.itis.bagaviev.data.music.api.data.network.playlist.entities.PlaylistDataEntity
import ru.kpfu.itis.bagaviev.data.music.api.data.network.track.entities.TrackDataEntity
import java.net.URI

class UserProfileDataEntity(
    val id: Long,
    val login: String,
    val email: String,
    val avatarUri: URI?,
    val tracks: List<TrackDataEntity>,
    val playlists: List<PlaylistDataEntity>
)