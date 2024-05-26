package ru.kpfu.itis.bagaviev.feature.profile.domain.entity.track

import ru.kpfu.itis.bagaviev.feature.profile.domain.entity.user.User

class MyTrack(
    val id: Long,
    val title: String,
    val users: List<User>,
    val smallCoverUri: String
)