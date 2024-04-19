package ru.kpfu.itis.auth.token.di

import dagger.Module

@Module(
    includes = [TokenRepositoryModule::class]
)
interface TokenModule