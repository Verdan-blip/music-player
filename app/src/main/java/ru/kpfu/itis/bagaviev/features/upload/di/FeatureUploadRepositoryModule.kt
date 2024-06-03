package ru.kpfu.itis.bagaviev.features.upload.di

import dagger.Binds
import dagger.Module
import ru.kpfu.itis.bagaviev.feature.upload.domain.repository.FeatureUploadAuthRepository
import ru.kpfu.itis.bagaviev.feature.upload.domain.repository.FeatureUploadSearchRepository
import ru.kpfu.itis.bagaviev.feature.upload.domain.repository.FeatureUploadTrackRepository
import ru.kpfu.itis.bagaviev.features.upload.AdapterFeatureUploadAuthRepository
import ru.kpfu.itis.bagaviev.features.upload.AdapterFeatureUploadSearchRepository
import ru.kpfu.itis.bagaviev.features.upload.AdapterFeatureUploadTrackRepository

@Module
interface FeatureUploadRepositoryModule {

    @Binds
    fun provideAdapterFeatureUploadTrackRepository_to_FeatureUploadTrackRepository(
        adapterUploadTrackRepository: AdapterFeatureUploadTrackRepository
    ): FeatureUploadTrackRepository

    @Binds
    fun provideAdapterFeatureSearchUserRepository_to_FeatureSearchUserRepository(
        adapterFeatureSearchUserRepository: AdapterFeatureUploadSearchRepository
    ): FeatureUploadSearchRepository

    @Binds
    fun provideAdapterFeatureUploadAuthRepository_to_FeatureUploadAuthRepository(
        adapterFeatureUploadAuthRepository: AdapterFeatureUploadAuthRepository
    ): FeatureUploadAuthRepository

}