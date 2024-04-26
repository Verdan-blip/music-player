package ru.kpfu.itis.bagaviev.api.domain.playlists.entites.responses

import ru.kpfu.itis.bagaviev.api.domain.tracks.entites.responses.TrackResponse
import ru.kpfu.itis.bagaviev.api.domain.users.response.UserResponse
import java.net.URI

class PlaylistResponse(

    val id: Long,

    val title: String,

    val coverUri: URI,

    val user: UserResponse,

    val tracks: List<TrackResponse>
)