package ru.kpfu.itis.bagaviev.glue.oauth.di

import dagger.Binds
import dagger.Module
import ru.kpfu.itis.bagaviev.glue.oauth.AdapterOAuthRouter
import ru.kpfu.itis.oauth.OAuthRouter

@Module
interface OAuthRouterModule {

    @Binds
    fun provideOAuthRouter(adapterOAuthRouter: AdapterOAuthRouter): OAuthRouter

}