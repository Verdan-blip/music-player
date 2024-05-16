package ru.kpfu.itis.bagaviev.feature.profile.domain.entity.user

import ru.kpfu.itis.bagaviev.feature.profile.domain.entity.playlist.MyPlaylist
import ru.kpfu.itis.bagaviev.feature.profile.domain.entity.track.MyTrack
import java.net.URI

class UserProfile(
    val id: Long,
    val login: String,
    val email: String,
    val avatarUri: URI?,
    val myTracks: List<MyTrack>,
    val myPlaylists: List<MyPlaylist>
)