package ru.kpfu.itis.bagaviev.features.upload.di

import dagger.Module

@Module(
    includes = [
        FeatureUploadRepositoryModule::class
    ]
)
interface FeatureUploadModule