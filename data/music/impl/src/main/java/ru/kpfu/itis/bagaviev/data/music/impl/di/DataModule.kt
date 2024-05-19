package ru.kpfu.itis.bagaviev.data.music.impl.di

import dagger.Module
import ru.kpfu.itis.bagaviev.data.music.impl.data.local.token.di.LocalModule
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.di.NetworkModule

@Module(
    includes = [
        NetworkModule::class,
        LocalModule::class
    ]
)
interface DataModule