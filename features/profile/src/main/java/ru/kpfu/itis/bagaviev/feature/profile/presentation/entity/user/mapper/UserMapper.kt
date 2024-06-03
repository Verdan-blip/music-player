package ru.kpfu.itis.bagaviev.feature.profile.presentation.entity.user.mapper

import ru.kpfu.itis.bagaviev.feature.profile.domain.entity.user.User
import ru.kpfu.itis.bagaviev.feature.profile.domain.entity.user.UserProfile
import ru.kpfu.itis.bagaviev.feature.profile.presentation.entity.track.mapper.toMyTrackModel
import ru.kpfu.itis.bagaviev.feature.profile.presentation.entity.user.UserModel
import ru.kpfu.itis.bagaviev.feature.profile.presentation.entity.user.UserProfileModel

fun User.toMyUserModel(): UserModel = UserModel(
    id = id,
    login = login
)

fun UserProfile.toUserDetailsModel(): UserProfileModel =
    UserProfileModel(
        id = id,
        login = login,
        email = email,
        avatarUri = avatarUri?.toString(),
        myTracks = myTracks.map { track -> track.toMyTrackModel() }
    )