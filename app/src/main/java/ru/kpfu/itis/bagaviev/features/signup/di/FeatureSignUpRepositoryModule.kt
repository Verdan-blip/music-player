package ru.kpfu.itis.bagaviev.features.signup.di

import dagger.Binds
import dagger.Module
import ru.kpfu.itis.bagaviev.feature.signup.domain.repository.FeatureSignUpAuthRepository
import ru.kpfu.itis.bagaviev.feature.signup.domain.repository.FeatureSignUpTokenRepository
import ru.kpfu.itis.bagaviev.features.signup.AdapterFeatureSignUpAuthRepository
import ru.kpfu.itis.bagaviev.features.signup.AdapterFeatureSignUpTokenRepository

@Module
interface FeatureSignUpRepositoryModule {

    @Binds
    fun provideAdapterSignUpRepository_to_SignUpRepository(
        adapterSignUpRepository: AdapterFeatureSignUpAuthRepository
    ): FeatureSignUpAuthRepository

    @Binds
    fun provideAdapterTokenRepository_to_TokenRepository(
        adapterTokenRepository: AdapterFeatureSignUpTokenRepository
    ): FeatureSignUpTokenRepository
}