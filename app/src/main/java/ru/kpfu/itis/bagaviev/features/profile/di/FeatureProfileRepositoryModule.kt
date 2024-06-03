package ru.kpfu.itis.bagaviev.features.profile.di

import dagger.Binds
import dagger.Module
import ru.kpfu.itis.bagaviev.feature.profile.domain.repository.FeatureProfileAuthRepository
import ru.kpfu.itis.bagaviev.feature.profile.domain.repository.FeatureProfileDownloadedTrackRepository
import ru.kpfu.itis.bagaviev.feature.profile.domain.repository.FeatureProfileUserRepository
import ru.kpfu.itis.bagaviev.features.profile.AdapterFeatureProfileAuthRepository
import ru.kpfu.itis.bagaviev.features.profile.AdapterFeatureProfileDownloadedTracksRepository
import ru.kpfu.itis.bagaviev.features.profile.AdapterFeatureProfileUserRepository

@Module
interface FeatureProfileRepositoryModule {

    @Binds
    fun provideAdapterProfileAuthRepository_to_ProfileAuthRepository(
        adapterProfileAuthRepository: AdapterFeatureProfileAuthRepository
    ): FeatureProfileAuthRepository

    @Binds
    fun provideAdapterUserRepository_to_UserRepository(
        adapterUserRepository: AdapterFeatureProfileUserRepository
    ): FeatureProfileUserRepository

    @Binds
    fun provideAdapterDownloadedTrackRepository_to_DownloadedTrackRepository(
        adapterFeatureProfileDownloadedTracksRepository: AdapterFeatureProfileDownloadedTracksRepository
    ): FeatureProfileDownloadedTrackRepository
}