package ru.kpfu.itis.bagaviev.feature.player.impl.di

import android.content.Context
import ru.kpfu.itis.bagaviev.common.di.connector.deps.ComponentDependenciesProvider
import ru.kpfu.itis.bagaviev.common.di.connector.holders.FeatureComponentHolder

object PlayerComponentHolder : FeatureComponentHolder<PlayerComponent>() {

    override fun initComponent(context: Context): PlayerComponent =
        DaggerPlayerComponent.factory()
            .create(ComponentDependenciesProvider.get(context))
}