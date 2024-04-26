package ru.kpfu.itis.bagaviev.api.domain.tracks.entites.responses

import java.net.URI
import java.sql.Timestamp

class TrackDetailsResponse(

    val id: Long,

    val title: String,

    val smallCoverUri: URI,

    val coverUri: URI,

    val audioFileUri: URI,

    val releaseTime: Timestamp,

    val playsCount: Int
)