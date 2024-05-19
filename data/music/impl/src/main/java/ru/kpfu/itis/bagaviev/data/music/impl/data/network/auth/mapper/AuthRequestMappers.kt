package ru.kpfu.itis.bagaviev.data.music.impl.data.network.auth.mapper

import ru.kpfu.itis.bagaviev.data.music.api.data.network.auth.entity.LoginDataEntity
import ru.kpfu.itis.bagaviev.data.music.api.data.network.auth.entity.RegisterDataEntity
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.auth.pojo.requests.LoginRequest
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.auth.pojo.requests.RegisterRequest

fun LoginRequest.toLoginDataEntity(): LoginDataEntity =
    LoginDataEntity(
        login = login,
        password = password
    )

fun LoginDataEntity.toLoginRequest(): LoginRequest =
    LoginRequest(
        login = login,
        password = password
    )

fun RegisterRequest.toRegisterDataEntity(): RegisterDataEntity =
    RegisterDataEntity(
        login = login,
        email = email,
        password = password
    )

fun RegisterDataEntity.toRegisterRequest(): RegisterRequest =
    RegisterRequest(
        login = login,
        email = email,
        password = password
    )