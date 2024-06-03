package ru.kpfu.itis.bagaviev.feature.upload.presentation.mapper

import ru.kpfu.itis.bagaviev.feature.upload.domain.entity.AuthorFeed
import ru.kpfu.itis.bagaviev.feature.upload.presentation.entity.UserFeedModel

fun UserFeedModel.toUser(): AuthorFeed = AuthorFeed(
    id = id,
    login = login,
    avatarUri = avatarUri
)

fun AuthorFeed.toUserModel(): UserFeedModel = UserFeedModel(
    id = id,
    login = login,
    avatarUri = avatarUri
)