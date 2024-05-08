package ru.kpfu.itis.oauth.di

import ru.kpfu.itis.bagaviev.common.di.connector.deps.ComponentDependencies
import ru.kpfu.itis.oauth.OAuthRouter
import ru.kpfu.itis.oauth.domain.repository.AuthTokenRepository
import ru.kpfu.itis.oauth.domain.repository.OAuthRepository

interface OAuthComponentDependencies : ComponentDependencies {

    fun authTokenRepository(): AuthTokenRepository

    fun authRepository(): OAuthRepository

    fun oAuthRouter(): OAuthRouter
}