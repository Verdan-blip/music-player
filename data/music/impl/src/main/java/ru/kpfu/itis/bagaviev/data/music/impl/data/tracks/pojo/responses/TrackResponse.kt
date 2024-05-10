package ru.kpfu.itis.bagaviev.data.music.impl.data.tracks.pojo.responses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.kpfu.itis.bagaviev.data.music.impl.data.users.pojo.responses.UserResponse

@Serializable
class TrackResponse(

    @SerialName("id")
    val id: Long,

    @SerialName("title")
    val title: String,

    @SerialName("users")
    val users: List<UserResponse>,

    @SerialName("smallCoverUri")
    val smallCoverUri: String
)