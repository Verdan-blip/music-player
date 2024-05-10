package ru.kpfu.itis.bagaviev.feed.impl.di.submodules

import dagger.Module
import ru.kpfu.itis.bagaviev.feed.impl.di.submodules.repositories.PlaylistRepositoryModule
import ru.kpfu.itis.bagaviev.feed.impl.di.submodules.repositories.TrackRepositoryModule

@Module(
    includes = [TrackRepositoryModule::class, PlaylistRepositoryModule::class]
)
interface FeedRepositoriesModule