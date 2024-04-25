package ru.kpfu.itis.bagaviev.data.tracks.entities.responses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class TrackDetailsResponse(

    @SerialName("id")
    val id: Long,

    @SerialName("title")
    val title: String,

    @SerialName("small_cover_uri")
    val smallCoverUri: String,

    @SerialName("cover_uri")
    val coverUri: String,

    @SerialName("audio_file_uri")
    val audioFileUri: String,

    @SerialName("release_time")
    val releaseTime: String,

    @SerialName("playsCount")
    val playsCount: Int
)