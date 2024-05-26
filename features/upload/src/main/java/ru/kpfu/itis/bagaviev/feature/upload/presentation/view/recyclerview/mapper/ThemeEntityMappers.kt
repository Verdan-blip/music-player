package ru.kpfu.itis.bagaviev.feature.upload.presentation.view.recyclerview.mapper

import ru.kpfu.itis.bagaviev.feature.upload.presentation.entity.UserModel
import ru.kpfu.itis.bagaviev.theme.recyclerview.model.AuthorRvModel

fun UserModel.toAuthorRvModel(): AuthorRvModel =
    AuthorRvModel(
        id = id,
        login = login,
        avatarUri = avatarUri
    )