package ru.kpfu.itis.bagaviev.data.music.impl.data.local.token.di.submodules

import dagger.Binds
import dagger.Module
import ru.kpfu.itis.bagaviev.data.music.api.data.local.token.repository.TokenDataRepository
import ru.kpfu.itis.bagaviev.data.music.impl.data.local.token.repository.SharedPreferencesTokenDataRepository

@Module
interface LocalRepositoryModule {

    @Binds
    fun provideSharedPreferencesTokenDataRepository_toTokenDataRepository(
        sharedPreferencesTokenDataRepository: SharedPreferencesTokenDataRepository
    ): TokenDataRepository
}