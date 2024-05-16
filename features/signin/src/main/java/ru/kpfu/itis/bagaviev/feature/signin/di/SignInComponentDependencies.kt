package ru.kpfu.itis.bagaviev.feature.signin.di

import ru.kpfu.itis.bagaviev.common.di.connector.deps.ComponentDependencies
import ru.kpfu.itis.bagaviev.feature.signin.SignInRouter
import ru.kpfu.itis.bagaviev.feature.signin.domain.repository.SignInRepository
import ru.kpfu.itis.bagaviev.feature.signin.domain.repository.SignInTokenRepository

interface SignInComponentDependencies : ComponentDependencies {

    val signInRepository: SignInRepository

    val signInTokenRepository: SignInTokenRepository

    val signInRouter: SignInRouter
}