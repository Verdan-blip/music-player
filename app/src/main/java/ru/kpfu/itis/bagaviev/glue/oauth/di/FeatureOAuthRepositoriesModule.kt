package ru.kpfu.itis.bagaviev.glue.oauth.di

import dagger.Binds
import dagger.Module
import ru.kpfu.itis.bagaviev.glue.oauth.AdapterAuthTokenRepository
import ru.kpfu.itis.bagaviev.glue.oauth.AdapterOAuthRepository
import ru.kpfu.itis.oauth.domain.repository.AuthTokenRepository
import ru.kpfu.itis.oauth.domain.repository.OAuthRepository

@Module
interface FeatureOAuthRepositoriesModule {

    @Binds
    fun providesAuthTokenRepository(
        adapterAuthTokenRepository: AdapterAuthTokenRepository
    ): AuthTokenRepository

    @Binds
    fun providesOAuthRepository(
        adapterOAuthRepository: AdapterOAuthRepository
    ): OAuthRepository

}