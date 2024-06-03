package ru.kpfu.itis.bagaviev.features.upload.mapper

import ru.kpfu.itis.bagaviev.data.music.api.data.network.user.entity.UserDataEntity
import ru.kpfu.itis.bagaviev.data.music.api.data.network.user.entity.UserProfileDataEntity
import ru.kpfu.itis.bagaviev.feature.upload.domain.entity.AuthorFeed

fun AuthorFeed.toUserDataEntity(): UserDataEntity =
    UserDataEntity(
        id = id,
        login = login,
        avatarUri = avatarUri
    )

fun UserDataEntity.toUser(): AuthorFeed = AuthorFeed(
    id = id,
    login = login,
    avatarUri = avatarUri
)

fun UserProfileDataEntity.toUser(): AuthorFeed = AuthorFeed(
    id = id,
    login = login,
    avatarUri = avatarUri.toString()
)