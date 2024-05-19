package ru.kpfu.itis.bagaviev.data.music.impl.data.network.track.pojo.responses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.user.pojo.responses.UserResponse

@Serializable
class TrackResponse(

    @SerialName("trackId")
    val trackId: Long,

    @SerialName("title")
    val title: String,

    @SerialName("users")
    val users: List<UserResponse>,

    @SerialName("smallCoverUri")
    val smallCoverUri: String
)