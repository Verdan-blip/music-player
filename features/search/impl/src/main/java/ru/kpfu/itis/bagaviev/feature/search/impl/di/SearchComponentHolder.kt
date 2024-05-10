package ru.kpfu.itis.bagaviev.feature.search.impl.di

import android.content.Context
import ru.kpfu.itis.bagaviev.common.di.connector.deps.ComponentDependenciesProvider
import ru.kpfu.itis.bagaviev.common.di.connector.holders.FeatureComponentHolder

object SearchComponentHolder : FeatureComponentHolder<SearchComponent>() {

    override fun initComponent(context: Context): SearchComponent =
        DaggerSearchComponent.factory().create(
            ComponentDependenciesProvider.get(context)
        )
}