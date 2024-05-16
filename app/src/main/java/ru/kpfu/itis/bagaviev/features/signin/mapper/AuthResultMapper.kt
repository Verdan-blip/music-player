package ru.kpfu.itis.bagaviev.features.signin.mapper

import ru.kpfu.itis.bagaviev.data.music.api.data.network.auth.entities.TokenDataEntity
import ru.kpfu.itis.bagaviev.feature.signin.domain.entities.SignInResult

fun TokenDataEntity.toAuthResult(): SignInResult =
    SignInResult(
        accessToken = accessToken,
        refreshToken = refreshToken
    )