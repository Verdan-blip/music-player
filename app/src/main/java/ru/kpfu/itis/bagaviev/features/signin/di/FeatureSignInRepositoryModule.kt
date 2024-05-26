package ru.kpfu.itis.bagaviev.features.signin.di

import dagger.Binds
import dagger.Module
import ru.kpfu.itis.bagaviev.feature.signin.domain.repository.FeatureSignInAuthRepository
import ru.kpfu.itis.bagaviev.feature.signin.domain.repository.FeatureSignInTokenRepository
import ru.kpfu.itis.bagaviev.features.signin.AdapterFeatureSignInAuthRepository
import ru.kpfu.itis.bagaviev.features.signin.AdapterFeatureSignInTokenRepository

@Module
interface FeatureSignInRepositoryModule {

    @Binds
    fun provideAdapterSignInRepository_to_SignInRepository(
        adapterSignInRepository: AdapterFeatureSignInAuthRepository
    ): FeatureSignInAuthRepository

    @Binds
    fun provideAdapterSignInTokenRepository_to_TokenRepository(
        adapterSignInTokenRepository: AdapterFeatureSignInTokenRepository
    ): FeatureSignInTokenRepository
}