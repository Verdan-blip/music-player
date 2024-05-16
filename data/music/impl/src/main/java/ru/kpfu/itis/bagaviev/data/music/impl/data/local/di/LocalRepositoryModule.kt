package ru.kpfu.itis.bagaviev.data.music.impl.data.local.di

import dagger.Binds
import dagger.Module
import ru.kpfu.itis.bagaviev.data.music.api.data.local.repository.TokenDataRepository
import ru.kpfu.itis.bagaviev.data.music.impl.data.local.repository.SharedPreferencesTokenDataRepository

@Module
interface LocalRepositoryModule {

    @Binds
    fun provideSharedPreferencesTokenDataRepository_toTokenDataRepository(
        sharedPreferencesTokenDataRepository: SharedPreferencesTokenDataRepository
    ): TokenDataRepository
}