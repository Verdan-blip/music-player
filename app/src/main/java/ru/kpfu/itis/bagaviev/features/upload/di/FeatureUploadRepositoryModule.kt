package ru.kpfu.itis.bagaviev.features.upload.di

import dagger.Binds
import dagger.Module
import ru.kpfu.itis.bagaviev.feature.upload.domain.repository.FeatureSearchUserRepository
import ru.kpfu.itis.bagaviev.feature.upload.domain.repository.FeatureUploadTrackRepository
import ru.kpfu.itis.bagaviev.features.upload.AdapterFeatureSearchUserRepository
import ru.kpfu.itis.bagaviev.features.upload.AdapterFeatureUploadTrackRepository

@Module
interface FeatureUploadRepositoryModule {

    @Binds
    fun provideAdapterFeatureUploadTrackRepository_to_FeatureUploadTrackRepository(
        adapterUploadTrackRepository: AdapterFeatureUploadTrackRepository
    ): FeatureUploadTrackRepository

    @Binds
    fun provideAdapterFeatureSearchUserRepository_to_FeatureSearchUserRepository(
        adapterFeatureSearchUserRepository: AdapterFeatureSearchUserRepository
    ): FeatureSearchUserRepository
}