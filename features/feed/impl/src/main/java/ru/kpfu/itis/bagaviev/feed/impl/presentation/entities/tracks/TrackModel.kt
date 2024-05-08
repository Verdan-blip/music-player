package ru.kpfu.itis.bagaviev.feed.impl.presentation.entities.tracks

import android.net.Uri
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entities.users.UserModel

@Parcelize
data class TrackModel(
    val id: Long,
    val title: String,
    val users: List<UserModel>,
    val smallCoverUri: Uri
): Parcelable