package ru.kpfu.itis.bagaviev.feature.upload.presentation.view.recyclerview.mapper

import ru.kpfu.itis.bagaviev.feature.upload.presentation.entity.UserFeedModel
import ru.kpfu.itis.bagaviev.theme.recyclerview.model.AuthorRvModel

fun UserFeedModel.toAuthorRvModel(): AuthorRvModel =
    AuthorRvModel(
        id = id,
        login = login,
        avatarUri = avatarUri
    )