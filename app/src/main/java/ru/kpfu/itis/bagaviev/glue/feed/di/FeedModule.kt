package ru.kpfu.itis.bagaviev.glue.feed.di

import dagger.Module

@Module(
    includes = [
        FeedRepositoriesModule::class,
        FeedMusicControllerModule::class,
        FeedRouterModule::class
    ]
)
interface FeedModule