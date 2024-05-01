package ru.kpfu.itis.bagaviev.impl.presentation.entities.users

import android.net.Uri
import ru.kpfu.itis.bagaviev.impl.presentation.entities.playlists.PlaylistModel
import ru.kpfu.itis.bagaviev.impl.presentation.entities.tracks.TrackModel

class UserDetailsModel(

    val id: Long,

    val login: String,

    val avatarUri: Uri,

    val tracks: List<TrackModel>,

    val playlists: List<PlaylistModel>
)