package ru.kpfu.itis.bagaviev.feature.search.api.domain.tracks.entites

import ru.kpfu.itis.bagaviev.feature.search.api.domain.users.User
import java.net.URI

class Track(
    val id: Long,
    val title: String,
    val users: List<User>,
    val smallCoverUri: URI
)