package ru.kpfu.itis.bagaviev.features.profile.di

import dagger.Module

@Module(
    includes = [
        FeatureProfileRouterModule::class,
        FeatureProfileRepositoryModule::class
    ]
)
interface FeatureProfileModule