package ru.kpfu.itis.bagaviev.api.domain.tracks.entites

import ru.kpfu.itis.bagaviev.api.domain.users.User

class Track(

    val id: Long,

    val title: String,

    val users: List<User>,

    val smallCoverUri: String
)