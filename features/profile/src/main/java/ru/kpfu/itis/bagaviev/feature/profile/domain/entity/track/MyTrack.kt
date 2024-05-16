package ru.kpfu.itis.bagaviev.feature.profile.domain.entity.track

import ru.kpfu.itis.bagaviev.feature.profile.domain.entity.user.User
import java.net.URI

class MyTrack(
    val id: Long,
    val title: String,
    val users: List<User>,
    val smallCoverUri: URI
)