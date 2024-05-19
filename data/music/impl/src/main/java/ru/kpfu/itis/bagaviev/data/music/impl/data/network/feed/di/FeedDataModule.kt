package ru.kpfu.itis.bagaviev.data.music.impl.data.network.feed.di

import dagger.Module
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.feed.di.submodules.FeedApiServiceModule
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.feed.di.submodules.FeedDataRepositoryModule

@Module(
    includes = [
        FeedApiServiceModule::class,
        FeedDataRepositoryModule::class
    ]
)
interface FeedDataModule