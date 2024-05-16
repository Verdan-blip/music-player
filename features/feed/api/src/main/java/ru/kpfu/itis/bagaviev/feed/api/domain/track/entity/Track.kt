package ru.kpfu.itis.bagaviev.feed.api.domain.track.entity

import ru.kpfu.itis.bagaviev.feed.api.domain.user.User
import java.net.URI

class Track(
    val id: Long,
    val title: String,
    val users: List<User>,
    val smallCoverUri: URI
)