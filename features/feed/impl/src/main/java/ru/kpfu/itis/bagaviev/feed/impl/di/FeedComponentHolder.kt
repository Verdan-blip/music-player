package ru.kpfu.itis.bagaviev.feed.impl.di

import android.annotation.SuppressLint
import android.content.Context
import ru.kpfu.itis.common.di.connector.deps.ComponentDependenciesProvider
import ru.kpfu.itis.common.di.connector.holders.FeatureComponentHolder

@SuppressLint("StaticFieldLeak")
object FeedComponentHolder : FeatureComponentHolder<FeedComponent>() {

    private var context: Context? = null

    fun provideContext(context: Context) {
        this.context = context
    }

    override fun buildComponent() {
        context?.also {
            component = DaggerFeedComponent.factory().create(
                ComponentDependenciesProvider.get(it)
            )
        }
    }

    override fun releaseComponent() {
        super.releaseComponent()
        context = null
    }
}