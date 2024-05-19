package ru.kpfu.itis.bagaviev.features.signup.mapper

import ru.kpfu.itis.bagaviev.data.music.api.data.network.auth.entity.RegisterDataEntity
import ru.kpfu.itis.bagaviev.feature.signup.domain.entities.SignUpForm

fun SignUpForm.toRegisterDataEntity(): RegisterDataEntity =
    RegisterDataEntity(
        login = login,
        email = email,
        password = password
    )