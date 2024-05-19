package ru.kpfu.itis.bagaviev.data.music.impl.data.network.auth.di.submodules

import dagger.Binds
import dagger.Module
import ru.kpfu.itis.bagaviev.data.music.api.data.network.auth.repository.AuthDataRepository
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.auth.repository.AuthDataRepositoryImpl

@Module
interface AuthDataRepositoryModule {

    @Binds
    fun provideAuthDataRepository(
        authDataRepositoryImpl: AuthDataRepositoryImpl
    ): AuthDataRepository
}