package ru.kpfu.itis.bagaviev.data.tracks.entities.responses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.kpfu.itis.bagaviev.data.common.entites.responses.UserResponse

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