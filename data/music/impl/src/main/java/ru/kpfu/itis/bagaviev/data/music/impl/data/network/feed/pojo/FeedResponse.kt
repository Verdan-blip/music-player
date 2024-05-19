package ru.kpfu.itis.bagaviev.data.music.impl.data.network.feed.pojo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.playlist.pojo.responses.PlaylistResponse
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.track.pojo.responses.TrackResponse

@Serializable
data class FeedResponse(

    @SerialName("chartTracks")
    val chartTracks: List<TrackResponse>,

    @SerialName("popularPlaylists")
    val popularPlaylists: List<PlaylistResponse>
)