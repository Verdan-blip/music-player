package ru.kpfu.itis.bagaviev.feed.impl.presentation.entities.tracks

import android.net.Uri
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entities.users.UserModel
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