package ru.kpfu.itis.bagaviev.feature.upload.presentation.mapper

import ru.kpfu.itis.bagaviev.common.util.extensions.toURI
import ru.kpfu.itis.bagaviev.feature.upload.domain.entity.User
import ru.kpfu.itis.bagaviev.feature.upload.presentation.entity.UserModel

fun UserModel.toUser(): User = User(
    id = id,
    login = login,
    avatarUri = avatarUri.toURI()
)

fun User.toUserModel(): UserModel = UserModel(
    id = id,
    login = login,
    avatarUri = avatarUri.toString()
)