package ru.kpfu.itis.bagaviev.data.music.impl.data.network.auth.di

import dagger.Module
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.auth.di.submodules.AccessTokenApiServiceModule
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.auth.di.submodules.AuthApiServiceModule
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.auth.di.submodules.AuthDataRepositoryModule
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.auth.di.submodules.RefreshTokenApiServiceModule

@Module(
    includes = [
        AuthApiServiceModule::class,
        AccessTokenApiServiceModule::class,
        RefreshTokenApiServiceModule::class,
        AuthDataRepositoryModule::class
    ]
)
interface AuthDataModule