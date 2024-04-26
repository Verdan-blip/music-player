package ru.kpfu.itis.bagaviev.feed.domain.playlists.entites.responses

import android.net.Uri
import ru.kpfu.itis.bagaviev.feed.domain.tracks.entites.responses.TrackResponseModel
import ru.kpfu.itis.bagaviev.feed.domain.users.response.UserResponseModel

class PlaylistResponseModel(

    val id: Long,

    val title: String,

    val coverUri: Uri,

    val user: UserResponseModel,

    val tracks: List<TrackResponseModel>
)