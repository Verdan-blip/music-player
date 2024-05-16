package ru.kpfu.itis.bagaviev.feature.profile.presentation.entity.playlist

import android.net.Uri
import ru.kpfu.itis.bagaviev.feature.profile.presentation.entity.track.MyTrackModel
import ru.kpfu.itis.bagaviev.feature.profile.presentation.entity.user.UserModel

class MyPlaylistModel(
    val id: Long,
    val title: String,
    val coverUri: Uri,
    val user: UserModel,
    val tracks: List<MyTrackModel>
)