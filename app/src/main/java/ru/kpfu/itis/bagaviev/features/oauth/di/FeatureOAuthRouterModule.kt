package ru.kpfu.itis.bagaviev.features.oauth.di

import dagger.Binds
import dagger.Module
import ru.kpfu.itis.bagaviev.features.oauth.AdapterOAuthRouter
import ru.kpfu.itis.oauth.OAuthRouter

@Module
interface FeatureOAuthRouterModule {

    @Binds
    fun provideOAuthRouter(adapterOAuthRouter: AdapterOAuthRouter): OAuthRouter
}