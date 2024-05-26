package ru.kpfu.itis.bagaviev.features.search.mapper

import ru.kpfu.itis.bagaviev.data.music.api.data.network.user.entity.UserDataEntity
import ru.kpfu.itis.bagaviev.feature.search.api.domain.author.entity.Author

fun UserDataEntity.toUser(): Author =
    Author(id = id, login = login)