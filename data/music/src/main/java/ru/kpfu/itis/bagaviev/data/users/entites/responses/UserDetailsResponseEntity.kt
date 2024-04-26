package ru.kpfu.itis.bagaviev.data.users.entites.responses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.kpfu.itis.bagaviev.data.playlists.entities.responses.PlaylistResponseEntity
import ru.kpfu.itis.bagaviev.data.tracks.entities.responses.TrackResponseEntity

@Serializable
class UserDetailsResponseEntity(

    @SerialName("id")
    val id: Long,

    @SerialName("login")
    val login: String,

    @SerialName("avatarUri")
    val avatarUri: String,

    @SerialName("tracks")
    val tracks: List<TrackResponseEntity>,

    @SerialName("playlists")
    val playlists: List<PlaylistResponseEntity>
)