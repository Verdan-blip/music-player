package ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.track

import android.net.Uri
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.user.UserModel

@Parcelize
data class TrackModel(
    val id: Long,
    val title: String,
    val users: List<UserModel>,
    val smallCoverUri: Uri
): Parcelable