package ru.kpfu.itis.bagaviev.features.signup.di

import dagger.Module

@Module(
    includes = [
        FeatureSignUpRouterModule::class,
        FeatureSignUpRepositoryModule::class
    ]
)
interface FeatureSignUpModule