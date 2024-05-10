package ru.kpfu.itis.bagaviev.data.music.api.data.users.entities

import ru.kpfu.itis.bagaviev.data.music.api.data.playlists.entities.PlaylistDataEntity
import ru.kpfu.itis.bagaviev.data.music.api.data.tracks.entities.TrackDataEntity
import java.net.URI

class UserDetailsDataEntity(
    val id: Long,
    val login: String,
    val avatarUri: URI,
    val tracks: List<TrackDataEntity>,
    val playlists: List<PlaylistDataEntity>
)