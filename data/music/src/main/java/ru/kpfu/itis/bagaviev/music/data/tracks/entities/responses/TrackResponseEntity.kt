package ru.kpfu.itis.bagaviev.music.data.tracks.entities.responses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.kpfu.itis.bagaviev.music.data.users.entites.responses.UserResponseEntity

@Serializable
class TrackResponseEntity(

    @SerialName("id")
    val id: Long,

    @SerialName("title")
    val title: String,

    @SerialName("users")
    val users: List<UserResponseEntity>,

    @SerialName("smallCoverUri")
    val smallCoverUri: String
)