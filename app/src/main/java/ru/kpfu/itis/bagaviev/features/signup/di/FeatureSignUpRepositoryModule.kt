package ru.kpfu.itis.bagaviev.features.signup.di

import dagger.Binds
import dagger.Module
import ru.kpfu.itis.bagaviev.feature.signup.domain.repository.SignUpRepository
import ru.kpfu.itis.bagaviev.feature.signup.domain.repository.SignUpTokenRepository
import ru.kpfu.itis.bagaviev.features.signup.AdapterSignUpRepository
import ru.kpfu.itis.bagaviev.features.signup.AdapterSignUpTokenRepository

@Module
interface FeatureSignUpRepositoryModule {

    @Binds
    fun provideAdapterSignUpRepository_to_SignUpRepository(
        adapterSignUpRepository: AdapterSignUpRepository
    ): SignUpRepository

    @Binds
    fun provideAdapterTokenRepository_to_TokenRepository(
        adapterTokenRepository: AdapterSignUpTokenRepository
    ): SignUpTokenRepository
}