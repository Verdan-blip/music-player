package ru.kpfu.itis.bagaviev.features.signin.mapper

import ru.kpfu.itis.bagaviev.data.music.api.data.network.auth.entity.TokenDataEntity
import ru.kpfu.itis.bagaviev.feature.signin.domain.entity.SignInResult

fun TokenDataEntity.toAuthResult(): SignInResult =
    SignInResult(
        accessToken = accessToken,
        refreshToken = refreshToken
    )