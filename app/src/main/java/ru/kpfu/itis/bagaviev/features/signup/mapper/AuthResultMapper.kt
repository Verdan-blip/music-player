package ru.kpfu.itis.bagaviev.features.signup.mapper

import ru.kpfu.itis.bagaviev.data.music.api.data.network.auth.entity.TokenDataEntity
import ru.kpfu.itis.bagaviev.feature.signup.domain.entities.SignUpResult

fun TokenDataEntity.toAuthResult(): SignUpResult =
    SignUpResult(
        accessToken = accessToken,
        refreshToken = refreshToken
    )