package ru.kpfu.itis.bagaviev.feature.search.impl.data.users.mappers

import ru.kpfu.itis.bagaviev.data.music.api.data.users.entities.UserDataEntity
import ru.kpfu.itis.bagaviev.feature.search.api.domain.users.User

fun UserDataEntity.toUser(): User =
    User(id = id, login = login)