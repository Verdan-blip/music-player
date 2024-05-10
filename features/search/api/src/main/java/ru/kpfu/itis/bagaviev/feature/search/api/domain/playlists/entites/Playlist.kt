package ru.kpfu.itis.bagaviev.feature.search.api.domain.playlists.entites

import ru.kpfu.itis.bagaviev.feature.search.api.domain.tracks.entites.Track
import ru.kpfu.itis.bagaviev.feature.search.api.domain.users.User
import java.net.URI

class Playlist(

    val id: Long,

    val title: String,

    val coverUri: URI,

    val user: User,

    val tracks: List<Track>
)