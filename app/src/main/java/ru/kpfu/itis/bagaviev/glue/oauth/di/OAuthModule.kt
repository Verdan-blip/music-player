package ru.kpfu.itis.bagaviev.glue.oauth.di

import dagger.Module


@Module(
    includes = [OAuthRepositoriesModule::class, OAuthRouterModule::class]
)
interface OAuthModule