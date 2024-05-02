package ru.kpfu.itis.bagaviev.music.data.playlists.entities.responses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.kpfu.itis.bagaviev.music.data.tracks.entities.responses.TrackResponseEntity
import ru.kpfu.itis.bagaviev.music.data.users.entites.responses.UserResponseEntity

@Serializable
class PlaylistResponseEntity(

    @SerialName("id")
    val id: Long,

    @SerialName("title")
    val title: String,

    @SerialName("coverUri")
    val coverUri: String,

    @SerialName("user")
    val user: UserResponseEntity,

    @SerialName("tracks")
    val tracks: List<TrackResponseEntity>
)