package ru.kpfu.itis.bagaviev.api.domain.users.response

import ru.kpfu.itis.bagaviev.api.domain.playlists.entites.responses.PlaylistResponse
import ru.kpfu.itis.bagaviev.api.domain.tracks.entites.responses.TrackResponse

class UserDetailsResponse(

    val id: Long,

    val login: String,

    val avatarUri: String,

    val tracks: List<TrackResponse>,

    val playlists: List<PlaylistResponse>
)