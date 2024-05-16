package ru.kpfu.itis.bagaviev.feature.profile.presentation.entity.track

import android.net.Uri
import ru.kpfu.itis.bagaviev.feature.profile.presentation.entity.user.UserModel
import java.net.URI

class MyTrackModel(
    val id: Long,
    val title: String,
    val users: List<UserModel>,
    val smallCoverUri: Uri
)