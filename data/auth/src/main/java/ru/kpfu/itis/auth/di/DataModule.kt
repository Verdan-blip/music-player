package ru.kpfu.itis.auth.di

import dagger.Module
import ru.kpfu.itis.auth.datasources.di.DataSourceModule
import ru.kpfu.itis.auth.oauth.di.OAuthModule
import ru.kpfu.itis.auth.token.di.TokenModule

@Module(
    includes = [DataSourceModule::class, OAuthModule::class, TokenModule::class]
)
interface DataModule