package ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.track

import android.net.Uri
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.user.UserModel
import java.util.Date

@Parcelize
class TrackDetailsModel(
    val id: Long,
    val title: String,
    val genre: String,
    val users: List<UserModel>,
    val smallCoverUri: Uri,
    val coverUri: Uri,
    val audioFileUri: Uri,
    val videoFileUri: Uri?,
    val releaseDate: Date,
    val playsCount: Int
): Parcelable