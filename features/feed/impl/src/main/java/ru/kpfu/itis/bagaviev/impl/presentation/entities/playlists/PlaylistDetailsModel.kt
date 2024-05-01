package ru.kpfu.itis.bagaviev.impl.presentation.entities.playlists

import android.net.Uri
import ru.kpfu.itis.bagaviev.impl.presentation.entities.tracks.TrackModel
import ru.kpfu.itis.bagaviev.impl.presentation.entities.users.UserModel
import java.util.Date

class PlaylistDetailsModel(

    val id: Long,

    val title: String,

    val user: UserModel,

    val coverUri: Uri,

    val tracks: List<TrackModel>,

    val createdTime: Date,

    val playsCount: Int
)