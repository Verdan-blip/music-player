package ru.kpfu.itis.bagaviev.player.di

import android.content.Context
import ru.kpfu.itis.common.di.connector.deps.ComponentDependenciesProvider
import ru.kpfu.itis.common.di.connector.holders.FeatureComponentHolder

object PlayerComponentHolder : FeatureComponentHolder<PlayerComponent>() {
    override fun createComponent(context: Context): PlayerComponent =
        DaggerPlayerComponent.factory()
            .create(ComponentDependenciesProvider.get(context))
}