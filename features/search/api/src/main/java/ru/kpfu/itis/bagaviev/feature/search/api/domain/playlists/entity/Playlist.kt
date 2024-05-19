package ru.kpfu.itis.bagaviev.feature.search.api.domain.playlists.entity

import ru.kpfu.itis.bagaviev.feature.search.api.domain.track.entity.Track
import ru.kpfu.itis.bagaviev.feature.search.api.domain.user.entity.User
import java.net.URI

class Playlist(

    val id: Long,

    val title: String,

    val coverUri: URI,

    val user: User,

    val tracks: List<Track>
)