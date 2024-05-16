package ru.kpfu.itis.bagaviev.data.music.impl.data.network.auth.mapper

import ru.kpfu.itis.bagaviev.data.music.api.data.network.auth.entities.TokenDataEntity
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.auth.pojo.responses.TokenResponse
import java.util.Calendar

fun TokenResponse.toAuthResultDataEntity(): TokenDataEntity =
    TokenDataEntity(
        accessToken = accessToken,
        refreshToken = refreshToken,
        expiresIn = Calendar.getInstance().time
    )