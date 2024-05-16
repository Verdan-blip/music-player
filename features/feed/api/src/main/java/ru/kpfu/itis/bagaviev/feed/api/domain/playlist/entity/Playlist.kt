package ru.kpfu.itis.bagaviev.feed.api.domain.playlist.entity

import ru.kpfu.itis.bagaviev.feed.api.domain.track.entity.Track
import ru.kpfu.itis.bagaviev.feed.api.domain.user.User
import java.net.URI

class Playlist(
    val id: Long,
    val title: String,
    val coverUri: URI,
    val user: User,
    val tracks: List<Track>
)