package ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.playlist

import android.net.Uri
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.track.TrackModel
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.user.UserModel

data class PlaylistModel(
    val id: Long,
    val title: String,
    val coverUri: Uri,
    val user: UserModel,
    val tracks: List<TrackModel>
)