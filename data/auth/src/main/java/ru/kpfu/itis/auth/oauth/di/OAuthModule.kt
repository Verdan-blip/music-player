package ru.kpfu.itis.auth.oauth.di

import dagger.Module

@Module(
    includes = [OAuthNetworkModule::class, OAuthRepositoryModule::class]
)
interface OAuthModule