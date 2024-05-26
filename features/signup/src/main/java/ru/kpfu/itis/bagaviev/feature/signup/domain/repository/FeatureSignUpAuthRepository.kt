package ru.kpfu.itis.bagaviev.feature.signup.domain.repository

import ru.kpfu.itis.bagaviev.feature.signup.domain.entity.SignUpResult
import ru.kpfu.itis.bagaviev.feature.signup.domain.entity.SignUpForm

interface FeatureSignUpAuthRepository {

    suspend fun signUp(signUpForm: SignUpForm): SignUpResult
}