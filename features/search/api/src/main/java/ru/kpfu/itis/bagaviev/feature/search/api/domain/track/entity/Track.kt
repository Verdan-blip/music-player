package ru.kpfu.itis.bagaviev.feature.search.api.domain.track.entity

import ru.kpfu.itis.bagaviev.feature.search.api.domain.user.entity.User
import java.net.URI

class Track(
    val id: Long,
    val title: String,
    val users: List<User>,
    val smallCoverUri: URI
)