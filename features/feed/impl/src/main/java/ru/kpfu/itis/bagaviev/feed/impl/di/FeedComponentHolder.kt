package ru.kpfu.itis.bagaviev.feed.impl.di

import android.content.Context
import ru.kpfu.itis.bagaviev.common.di.connector.deps.ComponentDependenciesProvider
import ru.kpfu.itis.bagaviev.common.di.connector.holders.FeatureComponentHolder

object FeedComponentHolder : FeatureComponentHolder<FeedComponent>() {

    override fun initComponent(context: Context): FeedComponent =
        DaggerFeedComponent.factory()
            .create(ComponentDependenciesProvider.get(context))
}