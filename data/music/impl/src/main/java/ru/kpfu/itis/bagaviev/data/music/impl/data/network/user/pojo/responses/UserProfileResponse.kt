package ru.kpfu.itis.bagaviev.data.music.impl.data.network.user.pojo.responses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.playlist.pojo.responses.PlaylistResponse
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.track.pojo.responses.TrackResponse

@Serializable
class UserProfileResponse(

    @SerialName("userId")
    val userId: Long,

    @SerialName("login")
    val login: String,

    @SerialName("email")
    val email: String,

    @SerialName("avatarUri")
    val avatarUri: String? = null,

    @SerialName("tracks")
    val tracks: List<TrackResponse>,

    @SerialName("playlists")
    val playlists: List<PlaylistResponse>
)