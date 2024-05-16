package ru.kpfu.itis.bagaviev.feature.profile.domain.entity.playlist

import ru.kpfu.itis.bagaviev.feature.profile.domain.entity.track.MyTrack
import ru.kpfu.itis.bagaviev.feature.profile.domain.entity.user.User
import java.net.URI

class MyPlaylist(
    val id: Long,
    val title: String,
    val coverUri: URI,
    val user: User,
    val myTracks: List<MyTrack>
)