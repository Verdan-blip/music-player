package ru.kpfu.itis.bagaviev.features.oauth.di

import dagger.Binds
import dagger.Module
import ru.kpfu.itis.bagaviev.features.oauth.AdapterAuthTokenRepository
import ru.kpfu.itis.bagaviev.features.oauth.AdapterOAuthRepository
import ru.kpfu.itis.oauth.domain.repository.AuthTokenRepository
import ru.kpfu.itis.oauth.domain.repository.OAuthRepository

@Module
interface FeatureOAuthRepositoryModule {

    @Binds
    fun providesAuthTokenRepository(
        adapterAuthTokenRepository: AdapterAuthTokenRepository
    ): AuthTokenRepository

    @Binds
    fun providesOAuthRepository(
        adapterOAuthRepository: AdapterOAuthRepository
    ): OAuthRepository

}