package ru.kpfu.itis.bagaviev.features.feed.di

import dagger.Module
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.di.NetworkModule
import ru.kpfu.itis.bagaviev.features.feed.di.submodules.FeatureFeedRepositoryModule
import ru.kpfu.itis.bagaviev.features.feed.di.submodules.FeatureFeedRouterModule
import ru.kpfu.itis.bagaviev.player.impl.di.PlayerModule

@Module(
    includes = [
        FeatureFeedRouterModule::class,
        FeatureFeedRepositoryModule::class,
        PlayerModule::class,
        NetworkModule::class
    ]
)
interface FeatureFeedModule