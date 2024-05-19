package ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.playlist

import android.net.Uri
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.track.TrackModel
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.user.UserModel
import java.util.Date

@Parcelize
class PlaylistDetailsModel(
    val id: Long,
    val title: String,
    val user: UserModel,
    val coverUri: Uri,
    val tracks: List<TrackModel>,
    val createdTime: Date,
    val playsCount: Int
): Parcelable