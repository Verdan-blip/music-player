package ru.kpfu.itis.bagaviev.feed.domain.users.response

import android.net.Uri
import ru.kpfu.itis.bagaviev.feed.domain.playlists.entites.responses.PlaylistResponseModel
import ru.kpfu.itis.bagaviev.feed.domain.tracks.entites.responses.TrackResponseModel

class UserDetailsResponseModel(

    val id: Long,

    val login: String,

    val avatarUri: Uri,

    val tracks: List<TrackResponseModel>,

    val playlists: List<PlaylistResponseModel>
)