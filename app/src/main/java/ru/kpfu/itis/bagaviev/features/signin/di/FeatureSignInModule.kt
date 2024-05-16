package ru.kpfu.itis.bagaviev.features.signin.di

import dagger.Module

@Module(
    includes = [
        FeatureSignInRouterModule::class,
        FeatureSignInRepositoryModule::class,
        FeatureSignInRouterModule::class
    ]
)
interface FeatureSignInModule