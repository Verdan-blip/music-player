package ru.kpfu.itis.bagaviev.feature.search.impl.presentation.entities.tracks

import android.net.Uri
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.entities.users.UserModel

data class TrackModel(
    val id: Long,
    val title: String,
    val users: List<UserModel>,
    val smallCoverUri: Uri
)