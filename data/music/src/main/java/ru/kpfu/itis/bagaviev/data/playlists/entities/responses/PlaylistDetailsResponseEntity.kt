package ru.kpfu.itis.bagaviev.data.playlists.entities.responses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.kpfu.itis.bagaviev.data.tracks.entities.responses.TrackResponseEntity
import ru.kpfu.itis.bagaviev.data.users.entites.responses.UserResponseEntity

@Serializable
class PlaylistDetailsResponseEntity(

    @SerialName("id")
    val id: Long,

    @SerialName("title")
    val title: String,

    @SerialName("coverUri")
    val coverUri: String,

    @SerialName("user")
    val user: UserResponseEntity,

    @SerialName("tracks")
    val tracks: List<TrackResponseEntity>,

    @SerialName("createdDate")
    val createdDate: String,

    @SerialName("playsCount")
    val playsCount: Int
)