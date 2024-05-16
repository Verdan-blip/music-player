package ru.kpfu.itis.bagaviev.features.oauth.di

import dagger.Module


@Module(
    includes = [
        FeatureOAuthRepositoriesModule::class,
        FeatureOAuthRouterModule::class
    ]
)
interface FeatureOAuthModule