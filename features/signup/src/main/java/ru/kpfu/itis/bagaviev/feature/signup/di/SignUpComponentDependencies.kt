package ru.kpfu.itis.bagaviev.feature.signup.di

import ru.kpfu.itis.bagaviev.common.di.connector.deps.ComponentDependencies
import ru.kpfu.itis.bagaviev.feature.signup.SignUpRouter
import ru.kpfu.itis.bagaviev.feature.signup.domain.repository.SignUpRepository
import ru.kpfu.itis.bagaviev.feature.signup.domain.repository.SignUpTokenRepository

interface SignUpComponentDependencies : ComponentDependencies {

    val signUpRepository: SignUpRepository

    val signUpTokenRepository: SignUpTokenRepository

    val signUpRouter: SignUpRouter
}