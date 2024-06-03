package ru.kpfu.itis.bagaviev.features.signin.mapper

import ru.kpfu.itis.bagaviev.data.music.api.data.network.auth.entity.LoginDataEntity
import ru.kpfu.itis.bagaviev.feature.signin.domain.entity.SignInForm

fun SignInForm.toRegisterDataEntity(): LoginDataEntity =
    LoginDataEntity(
        login = login,
        password = password
    )