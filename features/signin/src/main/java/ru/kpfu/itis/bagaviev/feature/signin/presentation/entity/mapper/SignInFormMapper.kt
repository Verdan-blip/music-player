package ru.kpfu.itis.bagaviev.feature.signin.presentation.entity.mapper

import ru.kpfu.itis.bagaviev.feature.signin.domain.entities.SignInForm
import ru.kpfu.itis.bagaviev.feature.signin.presentation.entity.SignInFormModel

fun SignInFormModel.toSignInForm(): SignInForm =
    SignInForm(
        login = login,
        password = password
    )