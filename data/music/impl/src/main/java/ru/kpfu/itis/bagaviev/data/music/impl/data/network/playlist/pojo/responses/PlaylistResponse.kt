package ru.kpfu.itis.bagaviev.data.music.impl.data.network.playlist.pojo.responses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.track.pojo.responses.TrackResponse
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.user.pojo.responses.UserResponse

@Serializable
class PlaylistResponse(

    @SerialName("playlistId")
    val playlistId: Long,

    @SerialName("title")
    val title: String,

    @SerialName("coverUri")
    val coverUri: String,

    @SerialName("user")
    val user: UserResponse,

    @SerialName("tracks")
    val tracks: List<TrackResponse>
)