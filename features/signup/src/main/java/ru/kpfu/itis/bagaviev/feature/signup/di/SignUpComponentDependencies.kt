package ru.kpfu.itis.bagaviev.feature.signup.di

import ru.kpfu.itis.bagaviev.common.di.connector.deps.ComponentDependencies
import ru.kpfu.itis.bagaviev.feature.signup.SignUpRouter
import ru.kpfu.itis.bagaviev.feature.signup.domain.repository.FeatureSignUpAuthRepository
import ru.kpfu.itis.bagaviev.feature.signup.domain.repository.FeatureSignUpTokenRepository

interface SignUpComponentDependencies : ComponentDependencies {

    val featureSignUpAuthRepository: FeatureSignUpAuthRepository

    val featureSignUpTokenRepository: FeatureSignUpTokenRepository

    val signUpRouter: SignUpRouter
}