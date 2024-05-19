package ru.kpfu.itis.bagaviev.data.music.impl.data.network.feed.di.submodules

import dagger.Binds
import dagger.Module
import ru.kpfu.itis.bagaviev.data.music.api.data.network.feed.repository.FeedDataRepository
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.feed.repository.FeedDataRepositoryImpl

@Module
interface FeedDataRepositoryModule {

    @Binds
    fun provideFeedDataRepositoryImpl_to_FeedDataRepository(
        feedDataRepositoryImpl: FeedDataRepositoryImpl
    ): FeedDataRepository
}