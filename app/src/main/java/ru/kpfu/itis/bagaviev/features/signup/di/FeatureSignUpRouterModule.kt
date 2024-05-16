package ru.kpfu.itis.bagaviev.features.signup.di

import dagger.Binds
import dagger.Module
import ru.kpfu.itis.bagaviev.feature.signup.SignUpRouter
import ru.kpfu.itis.bagaviev.features.signup.AdapterSignUpRouter

@Module
interface FeatureSignUpRouterModule {

    @Binds
    fun provideAdapterSignUpRouter_to_SignUpRouter(
        adapterSignUpRouter: AdapterSignUpRouter
    ): SignUpRouter
}