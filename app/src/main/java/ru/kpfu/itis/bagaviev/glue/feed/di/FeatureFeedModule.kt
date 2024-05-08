package ru.kpfu.itis.bagaviev.glue.feed.di

import dagger.Module
import ru.kpfu.itis.bagaviev.player.impl.di.PlayerModule

@Module(
    includes = [
        FeatureFeedRepositoriesModule::class,
        FeatureFeedRouterModule::class,
        PlayerModule::class
    ]
)
interface FeatureFeedModule