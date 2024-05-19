package ru.kpfu.itis.bagaviev.feed.impl.di.submodules

import dagger.Module
import ru.kpfu.itis.bagaviev.feed.impl.di.submodules.repository.FeedRepositoryModule
import ru.kpfu.itis.bagaviev.feed.impl.di.submodules.repository.PlaylistRepositoryModule
import ru.kpfu.itis.bagaviev.feed.impl.di.submodules.repository.TrackRepositoryModule

@Module(
    includes = [
        TrackRepositoryModule::class,
        PlaylistRepositoryModule::class,
        FeedRepositoryModule::class
    ]
)
internal interface RepositoryModule