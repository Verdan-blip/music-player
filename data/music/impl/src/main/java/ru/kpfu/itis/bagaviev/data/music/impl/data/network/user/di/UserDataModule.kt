package ru.kpfu.itis.bagaviev.data.music.impl.data.network.user.di

import dagger.Module
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.user.di.submodules.UserApiServiceModule
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.user.di.submodules.UserDataRepositoryModule

@Module(
    includes = [
        UserApiServiceModule::class,
        UserDataRepositoryModule::class
    ]
)
interface UserDataModule