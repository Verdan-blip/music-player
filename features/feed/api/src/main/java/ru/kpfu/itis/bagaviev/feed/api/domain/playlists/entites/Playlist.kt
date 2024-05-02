package ru.kpfu.itis.bagaviev.feed.api.domain.playlists.entites

import ru.kpfu.itis.bagaviev.feed.api.domain.tracks.entites.Track
import ru.kpfu.itis.bagaviev.feed.api.domain.users.User
import java.net.URI

class Playlist(

    val id: Long,

    val title: String,

    val coverUri: URI,

    val user: User,

    val tracks: List<Track>
)