package ru.kpfu.itis.auth.di

import dagger.Module

@Module(
    includes = [DataSourceModule::class, RepositoriesModule::class]
)
interface DataModule