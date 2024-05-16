package ru.kpfu.itis.bagaviev.feed.impl.data.user.mapper

import ru.kpfu.itis.bagaviev.data.music.api.data.network.user.entity.UserDataEntity
import ru.kpfu.itis.bagaviev.feed.api.domain.user.User

fun UserDataEntity.toUser(): User =
    User(id = id, login = login)