package ru.kpfu.itis.bagaviev.features.upload.di

import dagger.Binds
import dagger.Module
import ru.kpfu.itis.bagaviev.feature.upload.UploadRouter
import ru.kpfu.itis.bagaviev.features.upload.AdapterUploadRouter

@Module
interface FeatureUploadRouterModule {

    @Binds
    fun provideAdapterUploadRouter_to_UploadRouter(
        adapterUploadRouter: AdapterUploadRouter
    ): UploadRouter
}