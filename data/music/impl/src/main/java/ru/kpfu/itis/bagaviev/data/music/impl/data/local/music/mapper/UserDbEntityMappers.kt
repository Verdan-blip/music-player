package ru.kpfu.itis.bagaviev.data.music.impl.data.local.music.mapper

import ru.kpfu.itis.bagaviev.data.music.api.data.network.user.entity.UserDataEntity
import ru.kpfu.itis.bagaviev.data.music.impl.data.local.music.entity.UserDbEntity

fun UserDbEntity.toUserDataEntity(): UserDataEntity =
    UserDataEntity(
        id = id,
        login = login,
        avatarUri = avatarUri
    )