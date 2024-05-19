package ru.kpfu.itis.bagaviev.feed.impl.di.submodules.repository

import dagger.Binds
import dagger.Module
import ru.kpfu.itis.bagaviev.feed.api.domain.feed.repository.FeedRepository
import ru.kpfu.itis.bagaviev.feed.impl.data.feed.repository.FeedRepositoryImpl

@Module
internal interface FeedRepositoryModule {

    @Binds
    fun provideFeedRepositoryImpl_to_FeedRepository(
        feedRepositoryImpl: FeedRepositoryImpl
    ): FeedRepository
}