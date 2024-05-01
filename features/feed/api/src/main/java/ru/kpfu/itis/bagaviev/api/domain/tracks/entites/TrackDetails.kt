package ru.kpfu.itis.bagaviev.api.domain.tracks.entites

import ru.kpfu.itis.bagaviev.api.domain.users.User
import java.net.URI
import java.util.Date

class TrackDetails(

    val id: Long,

    val title: String,

    val genre: String,

    val users: List<User>,

    val lyrics: String? = null,

    val smallCoverUri: URI,

    val coverUri: URI,

    val audioFileUri: URI,

    val videoFileUri: URI?,

    val releaseDate: Date,

    val playsCount: Int
)