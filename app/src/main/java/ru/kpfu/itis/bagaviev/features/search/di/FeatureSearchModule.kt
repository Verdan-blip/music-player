package ru.kpfu.itis.bagaviev.features.search.di

import dagger.Module
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.di.NetworkModule
import ru.kpfu.itis.bagaviev.player.impl.di.PlayerModule

@Module(
    includes = [
        PlayerModule::class,
        NetworkModule::class
    ]
)
interface FeatureSearchModule