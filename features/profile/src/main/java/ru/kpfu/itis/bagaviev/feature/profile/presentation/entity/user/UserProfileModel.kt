package ru.kpfu.itis.bagaviev.feature.profile.presentation.entity.user

import ru.kpfu.itis.bagaviev.feature.profile.presentation.entity.track.MyTrackModel

class UserProfileModel(
    val id: Long,
    val login: String,
    val email: String,
    val name: String? = null,
    val lastname: String? = null,
    val avatarUri: String?,
    val myTracks: List<MyTrackModel>
)