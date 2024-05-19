package ru.kpfu.itis.bagaviev.feature.search.api.domain.playlists.entity

import ru.kpfu.itis.bagaviev.feature.search.api.domain.track.entity.Track
import ru.kpfu.itis.bagaviev.feature.search.api.domain.user.entity.User
import java.net.URI
import java.util.Date

class PlaylistDetails(

    val id: Long,

    val title: String,

    val user: User,

    val coverUri: URI,

    val tracks: List<Track>,

    val createdDate: Date,

    val playsCount: Int
)