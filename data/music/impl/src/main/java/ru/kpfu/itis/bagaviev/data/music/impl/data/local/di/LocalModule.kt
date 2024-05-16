package ru.kpfu.itis.bagaviev.data.music.impl.data.local.di

import dagger.Module

@Module(
    includes = [
        LocalDatasourceModule::class,
        LocalRepositoryModule::class
    ]
)
interface LocalModule