package ru.kpfu.itis.bagaviev.data.music.impl.data.network.auth.di

import dagger.Module
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.auth.di.submodules.AuthApiServiceModule
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.auth.di.submodules.AuthRepositoryDataModule

@Module(
    includes = [
        AuthApiServiceModule::class,
        AuthRepositoryDataModule::class
    ]
)
interface AuthDataModule