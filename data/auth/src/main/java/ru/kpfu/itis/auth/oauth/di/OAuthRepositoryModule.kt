package ru.kpfu.itis.auth.oauth.di

import dagger.Binds
import dagger.Module
import ru.kpfu.itis.auth.oauth.repository.JamendoApiOAuthDataRepository
import ru.kpfu.itis.auth.oauth.repository.OAuthDataRepository

@Module
interface OAuthRepositoryModule {

    @Binds
    fun provideJamendoApiOAuthDataRepository_to_OAuthDataRepository(
        jamendoApiOAuthDataRepository: JamendoApiOAuthDataRepository
    ): OAuthDataRepository
}