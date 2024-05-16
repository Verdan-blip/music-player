package ru.kpfu.itis.bagaviev.features.feed.di

import dagger.Binds
import dagger.Module
import ru.kpfu.itis.bagaviev.feed.impl.FeedRouter
import ru.kpfu.itis.bagaviev.features.feed.AdapterFeedRouter

@Module
interface FeatureFeedRouterModule {

    @Binds
    fun provideFeedRouter(adapterFeedRouter: AdapterFeedRouter): FeedRouter
}