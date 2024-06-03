package ru.kpfu.itis.bagaviev.data.music.impl.data.local.token.di

import dagger.Module
import ru.kpfu.itis.bagaviev.data.music.impl.data.local.token.di.submodules.LocalDatasourceModule
import ru.kpfu.itis.bagaviev.data.music.impl.data.local.token.di.submodules.LocalRepositoryModule

@Module(
    includes = [
        LocalDatasourceModule::class,
        LocalRepositoryModule::class
    ]
)
interface LocalTokenModule