package ru.kpfu.itis.bagaviev.feature.signup.domain.repository

import ru.kpfu.itis.bagaviev.feature.signup.domain.entities.SignUpResult
import ru.kpfu.itis.bagaviev.feature.signup.domain.entities.SignUpForm

interface SignUpRepository {

    suspend fun signUp(signUpForm: SignUpForm): SignUpResult
}