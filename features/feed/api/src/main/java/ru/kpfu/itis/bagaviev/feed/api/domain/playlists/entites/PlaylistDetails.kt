package ru.kpfu.itis.bagaviev.feed.api.domain.playlists.entites

import ru.kpfu.itis.bagaviev.feed.api.domain.tracks.entites.Track
import ru.kpfu.itis.bagaviev.feed.api.domain.users.User
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