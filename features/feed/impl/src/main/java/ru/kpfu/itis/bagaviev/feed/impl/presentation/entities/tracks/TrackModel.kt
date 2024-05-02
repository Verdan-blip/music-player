package ru.kpfu.itis.bagaviev.feed.impl.presentation.entities.tracks

import android.net.Uri
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entities.users.UserModel

data class TrackModel(

    val id: Long,

    val title: String,

    val users: List<UserModel>,

    val smallCoverUri: Uri
)