package ru.kpfu.itis.bagaviev.feature.signup.presentation.entities.mappers

import ru.kpfu.itis.bagaviev.feature.signup.domain.entity.SignUpForm
import ru.kpfu.itis.bagaviev.feature.signup.presentation.entities.SignUpFormModel

fun SignUpFormModel.toSignUpForm(): SignUpForm =
    SignUpForm(
        email = email,
        login = login,
        password = password,
        confirmedPassword = confirmedPassword
    )