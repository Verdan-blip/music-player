package ru.kpfu.itis.bagaviev.feed.api.domain.playlist.entity

import ru.kpfu.itis.bagaviev.feed.api.domain.track.entity.Track
import ru.kpfu.itis.bagaviev.feed.api.domain.user.User
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