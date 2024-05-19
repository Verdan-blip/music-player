package ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.user

import android.net.Uri
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.playlist.PlaylistModel
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.track.TrackModel

class UserDetailsModel(

    val id: Long,

    val login: String,

    val avatarUri: Uri,

    val tracks: List<TrackModel>,

    val playlists: List<PlaylistModel>
)