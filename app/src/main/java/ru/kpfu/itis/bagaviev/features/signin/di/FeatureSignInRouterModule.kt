package ru.kpfu.itis.bagaviev.features.signin.di

import dagger.Binds
import dagger.Module
import ru.kpfu.itis.bagaviev.feature.signin.SignInRouter
import ru.kpfu.itis.bagaviev.features.signin.AdapterSignInRouter

@Module
interface FeatureSignInRouterModule {

    @Binds
    fun provideAdapterSignInRouter_to_SignInRouter(
        adapterSignInRouter: AdapterSignInRouter
    ): SignInRouter
}