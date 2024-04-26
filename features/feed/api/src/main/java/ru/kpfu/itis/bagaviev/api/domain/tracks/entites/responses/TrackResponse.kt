package ru.kpfu.itis.bagaviev.api.domain.tracks.entites.responses

import ru.kpfu.itis.bagaviev.api.domain.users.response.UserResponse

class TrackResponse(

    val id: Long,

    val title: String,

    val users: List<UserResponse>,

    val smallCoverUri: String
)