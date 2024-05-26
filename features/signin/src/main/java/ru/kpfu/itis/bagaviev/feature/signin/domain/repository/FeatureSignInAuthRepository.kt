package ru.kpfu.itis.bagaviev.feature.signin.domain.repository

import ru.kpfu.itis.bagaviev.feature.signin.domain.entities.SignInResult
import ru.kpfu.itis.bagaviev.feature.signin.domain.entities.SignInForm

interface FeatureSignInAuthRepository {

    suspend fun signIn(signInForm: SignInForm): SignInResult
}