package ru.kpfu.itis.bagaviev.api.domain.playlists.entites.responses

import ru.kpfu.itis.bagaviev.api.domain.tracks.entites.responses.TrackResponse
import java.net.URI
import java.sql.Timestamp

class PlaylistDetailsResponse(

    val id: Long,

    val title: String,

    val coverUri: URI,

    val tracks: List<TrackResponse>,

    val createdTime: Timestamp,

    val playsCount: Int
)