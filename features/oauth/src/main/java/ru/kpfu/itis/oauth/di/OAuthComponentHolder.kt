package ru.kpfu.itis.oauth.di

import android.content.Context
import ru.kpfu.itis.bagaviev.common.di.connector.deps.ComponentDependenciesProvider
import ru.kpfu.itis.bagaviev.common.di.connector.holders.FeatureComponentHolder

object OAuthComponentHolder : FeatureComponentHolder<OAuthComponent>() {

    override fun initComponent(context: Context): OAuthComponent =
        DaggerOAuthComponent.factory()
            .create(ComponentDependenciesProvider.get(context))
}