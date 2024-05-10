package ru.kpfu.itis.bagaviev.data.music.impl.data.users.pojo.responses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.kpfu.itis.bagaviev.data.music.impl.data.playlists.pojo.responses.PlaylistResponse
import ru.kpfu.itis.bagaviev.data.music.impl.data.tracks.pojo.responses.TrackResponse

@Serializable
class UserDetailsResponseEntity(

    @SerialName("id")
    val id: Long,

    @SerialName("login")
    val login: String,

    @SerialName("avatarUri")
    val avatarUri: String,

    @SerialName("tracks")
    val tracks: List<TrackResponse>,

    @SerialName("playlists")
    val playlists: List<PlaylistResponse>
)