package ru.kpfu.itis.bagaviev.feature.profile.presentation.entity.track

import ru.kpfu.itis.bagaviev.feature.profile.presentation.entity.user.UserModel

class MyTrackModel(
    val id: Long,
    val title: String,
    val users: List<UserModel>,
    val smallCoverUri: String
)