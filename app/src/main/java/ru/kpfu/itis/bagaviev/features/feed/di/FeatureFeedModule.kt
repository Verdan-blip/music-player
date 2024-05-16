package ru.kpfu.itis.bagaviev.features.feed.di

import dagger.Module
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.di.NetworkModule
import ru.kpfu.itis.bagaviev.player.impl.di.PlayerModule

@Module(
    includes = [
        FeatureFeedRouterModule::class,
        PlayerModule::class,
        NetworkModule::class
    ]
)
interface FeatureFeedModule