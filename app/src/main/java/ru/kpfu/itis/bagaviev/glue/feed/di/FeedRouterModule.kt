package ru.kpfu.itis.bagaviev.glue.feed.di

import dagger.Binds
import dagger.Module
import ru.kpfu.itis.bagaviev.feed.impl.FeedRouter
import ru.kpfu.itis.bagaviev.glue.feed.AdapterFeedRouter

@Module
interface FeedRouterModule {

    @Binds
    fun provideFeedRouter(adapterFeedRouter: AdapterFeedRouter): FeedRouter
}