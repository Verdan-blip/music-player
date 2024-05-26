package ru.kpfu.itis.bagaviev.feature.signin.di

import ru.kpfu.itis.bagaviev.common.di.connector.deps.ComponentDependencies
import ru.kpfu.itis.bagaviev.feature.signin.SignInRouter
import ru.kpfu.itis.bagaviev.feature.signin.domain.repository.FeatureSignInAuthRepository
import ru.kpfu.itis.bagaviev.feature.signin.domain.repository.FeatureSignInTokenRepository

interface SignInComponentDependencies : ComponentDependencies {

    val featureSignInAuthRepository: FeatureSignInAuthRepository

    val featureSignInTokenRepository: FeatureSignInTokenRepository

    val signInRouter: SignInRouter
}