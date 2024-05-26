package ru.kpfu.itis.bagaviev.features.upload.mapper

import ru.kpfu.itis.bagaviev.common.util.extensions.toURI
import ru.kpfu.itis.bagaviev.common.util.extensions.toUri
import ru.kpfu.itis.bagaviev.data.music.api.data.network.user.entity.UserDataEntity
import ru.kpfu.itis.bagaviev.feature.upload.domain.entity.User

fun User.toUserDataEntity(): UserDataEntity =
    UserDataEntity(
        id = id,
        login = login,
        avatarUri = avatarUri?.toUri()
    )

fun UserDataEntity.toUser(): User = User(
    id = id,
    login = login,
    avatarUri = avatarUri?.toURI()
)