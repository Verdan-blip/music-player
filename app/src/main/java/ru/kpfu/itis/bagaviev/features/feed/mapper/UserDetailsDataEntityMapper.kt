package ru.kpfu.itis.bagaviev.features.feed.mapper

import ru.kpfu.itis.bagaviev.data.music.api.data.network.user.entity.UserDataEntity
import ru.kpfu.itis.bagaviev.feed.api.domain.author.entity.Author

fun UserDataEntity.toUser(): Author =
    Author(id = id, login = login)