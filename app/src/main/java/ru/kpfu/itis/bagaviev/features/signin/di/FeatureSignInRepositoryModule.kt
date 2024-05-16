package ru.kpfu.itis.bagaviev.features.signin.di

import dagger.Binds
import dagger.Module
import ru.kpfu.itis.bagaviev.feature.signin.domain.repository.SignInRepository
import ru.kpfu.itis.bagaviev.feature.signin.domain.repository.SignInTokenRepository
import ru.kpfu.itis.bagaviev.features.signin.AdapterSignInRepository
import ru.kpfu.itis.bagaviev.features.signin.AdapterSignInTokenRepository

@Module
interface FeatureSignInRepositoryModule {

    @Binds
    fun provideAdapterSignInRepository_to_SignInRepository(
        adapterSignInRepository: AdapterSignInRepository
    ): SignInRepository

    @Binds
    fun provideAdapterSignInTokenRepository_to_TokenRepository(
        adapterSignInTokenRepository: AdapterSignInTokenRepository
    ): SignInTokenRepository
}