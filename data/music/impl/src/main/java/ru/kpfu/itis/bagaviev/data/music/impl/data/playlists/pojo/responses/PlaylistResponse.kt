package ru.kpfu.itis.bagaviev.data.music.impl.data.playlists.pojo.responses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.kpfu.itis.bagaviev.data.music.impl.data.tracks.pojo.responses.TrackResponse
import ru.kpfu.itis.bagaviev.data.music.impl.data.users.pojo.responses.UserResponse

@Serializable
class PlaylistResponse(

    @SerialName("id")
    val id: Long,

    @SerialName("title")
    val title: String,

    @SerialName("coverUri")
    val coverUri: String,

    @SerialName("user")
    val user: UserResponse,

    @SerialName("tracks")
    val tracks: List<TrackResponse>
)