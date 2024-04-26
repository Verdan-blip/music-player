package ru.kpfu.itis.bagaviev.data.playlists.entities.responses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.kpfu.itis.bagaviev.data.tracks.entities.responses.TrackResponseEntity

@Serializable
class PlaylistDetailsResponseEntity(

    @SerialName("id")
    val id: Long,

    @SerialName("title")
    val title: String,

    @SerialName("coverUri")
    val coverUri: String,

    @SerialName("tracks")
    val tracks: List<TrackResponseEntity>,

    @SerialName("createdTime")
    val createdTime: String,

    @SerialName("playsCount")
    val playsCount: Int
)