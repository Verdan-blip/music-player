package ru.kpfu.itis.bagaviev.features.profile.di

import dagger.Binds
import dagger.Module
import ru.kpfu.itis.bagaviev.feature.profile.domain.repository.ProfileAuthRepository
import ru.kpfu.itis.bagaviev.feature.profile.domain.repository.UserRepository
import ru.kpfu.itis.bagaviev.features.profile.AdapterProfileAuthRepository
import ru.kpfu.itis.bagaviev.features.profile.AdapterUserRepository

@Module
interface FeatureProfileRepositoryModule {

    @Binds
    fun provideAdapterProfileAuthRepository_to_ProfileAuthRepository(
        adapterProfileAuthRepository: AdapterProfileAuthRepository
    ): ProfileAuthRepository

    @Binds
    fun provideAdapterUserRepository_to_UserRepository(
        adapterUserRepository: AdapterUserRepository
    ): UserRepository
}