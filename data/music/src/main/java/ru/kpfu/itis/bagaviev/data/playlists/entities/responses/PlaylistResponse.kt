package ru.kpfu.itis.bagaviev.data.playlists.entities.responses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.kpfu.itis.bagaviev.data.tracks.entities.responses.TrackResponse
import ru.kpfu.itis.bagaviev.data.common.entites.responses.UserResponse

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