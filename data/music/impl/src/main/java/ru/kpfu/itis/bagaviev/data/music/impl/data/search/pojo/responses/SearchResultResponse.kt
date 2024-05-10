package ru.kpfu.itis.bagaviev.data.music.impl.data.search.pojo.responses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.kpfu.itis.bagaviev.data.music.impl.data.playlists.pojo.responses.PlaylistResponse
import ru.kpfu.itis.bagaviev.data.music.impl.data.tracks.pojo.responses.TrackResponse
import ru.kpfu.itis.bagaviev.data.music.impl.data.users.pojo.responses.UserResponse

@Serializable
class SearchResultResponse(

    @SerialName("users")
    val users: List<UserResponse>,

    @SerialName("tracks")
    val tracks: List<TrackResponse>,

    @SerialName("playlists")
    val playlists: List<PlaylistResponse>
)