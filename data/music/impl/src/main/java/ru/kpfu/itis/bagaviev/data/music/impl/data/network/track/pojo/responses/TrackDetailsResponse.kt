package ru.kpfu.itis.bagaviev.data.music.impl.data.network.track.pojo.responses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.user.pojo.responses.UserResponse

@Serializable
class TrackDetailsResponse(

    @SerialName("trackId")
    val trackId: Long,

    @SerialName("title")
    val title: String,

    @SerialName("genre")
    val genre: String,

    @SerialName("lyrics")
    val lyrics: String? = null,

    @SerialName("users")
    val users: List<UserResponse>,

    @SerialName("smallCoverUri")
    val smallCoverUri: String,

    @SerialName("coverUri")
    val coverUri: String,

    @SerialName("audioFileUri")
    val audioFileUri: String,

    @SerialName("videoFileUri")
    val videoFileUri: String? = null,

    @SerialName("releaseDate")
    val releaseDate: String,

    @SerialName("playsCount")
    val playsCount: Int,

    @SerialName("clipData")
    val clipData: ClipData? = null
)