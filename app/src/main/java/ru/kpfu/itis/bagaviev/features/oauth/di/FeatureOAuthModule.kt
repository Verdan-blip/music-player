package ru.kpfu.itis.bagaviev.features.oauth.di

import dagger.Module


@Module(
    includes = [
        FeatureOAuthRepositoryModule::class,
        FeatureOAuthRouterModule::class
    ]
)
interface FeatureOAuthModule