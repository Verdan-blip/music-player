package ru.kpfu.itis.auth.di

import dagger.Binds
import dagger.Module
import ru.kpfu.itis.auth.token.repository.AuthTokenRepository
import ru.kpfu.itis.auth.token.repository.SharedPreferencesAuthTokenRepository

@Module
interface RepositoriesModule {

    @Binds
    fun provideSharedPreferencesAuthTokenRepository_to_AuthTokenRepository(
        sharedPreferencesAuthTokenRepository: SharedPreferencesAuthTokenRepository
    ): AuthTokenRepository
}