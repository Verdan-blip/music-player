package ru.kpfu.itis.bagaviev.glue.oauth.di

import dagger.Module


@Module(
    includes = [
        FeatureOAuthRepositoriesModule::class,
        FeatureOAuthRouterModule::class
    ]
)
interface FeatureOAuthModule