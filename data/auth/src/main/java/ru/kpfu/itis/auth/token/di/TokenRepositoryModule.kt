package ru.kpfu.itis.auth.token.di

import dagger.Binds
import dagger.Module
import ru.kpfu.itis.auth.token.repository.AuthTokenDataRepository
import ru.kpfu.itis.auth.token.repository.SharedPreferencesAuthTokenDataRepository

@Module
interface TokenRepositoryModule {
    @Binds
    fun provideSharedPreferencesAuthTokenDataRepository_to_AuthTokenDataRepository(
        sharedPreferencesAuthTokenDataRepository: SharedPreferencesAuthTokenDataRepository
    ): AuthTokenDataRepository
}