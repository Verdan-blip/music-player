package ru.kpfu.itis.bagaviev.feature.profile.di

import android.content.Context
import ru.kpfu.itis.bagaviev.common.di.connector.deps.ComponentDependenciesProvider
import ru.kpfu.itis.bagaviev.common.di.connector.holders.FeatureComponentHolder

object ProfileComponentHolder : FeatureComponentHolder<ProfileComponent>() {

    override fun initComponent(context: Context): ProfileComponent =
        DaggerProfileComponent.factory()
            .create(ComponentDependenciesProvider.get(context))
}