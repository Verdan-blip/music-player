package ru.kpfu.itis.bagaviev.data.music.impl.data.network.auth.mapper

import ru.kpfu.itis.bagaviev.data.music.api.data.network.auth.entity.TokenDataEntity
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.auth.pojo.responses.TokenResponse

fun TokenResponse.toAuthResultDataEntity(): TokenDataEntity =
    TokenDataEntity(
        accessToken = accessToken,
        refreshToken = refreshToken,
        expiresIn = expiresIn
    )