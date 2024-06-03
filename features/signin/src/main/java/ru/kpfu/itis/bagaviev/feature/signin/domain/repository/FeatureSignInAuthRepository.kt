package ru.kpfu.itis.bagaviev.feature.signin.domain.repository

import ru.kpfu.itis.bagaviev.feature.signin.domain.entity.SignInResult
import ru.kpfu.itis.bagaviev.feature.signin.domain.entity.SignInForm

interface FeatureSignInAuthRepository {

    suspend fun signIn(signInForm: SignInForm): SignInResult
}