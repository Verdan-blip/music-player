package ru.kpfu.itis.bagaviev.feature.signin.di

import android.content.Context
import ru.kpfu.itis.bagaviev.common.di.connector.deps.ComponentDependenciesProvider
import ru.kpfu.itis.bagaviev.common.di.connector.holders.FeatureComponentHolder

object SignInComponentHolder : FeatureComponentHolder<SignInComponent>() {

    override fun initComponent(context: Context): SignInComponent =
        DaggerSignInComponent.factory()
            .create(ComponentDependenciesProvider.get(context))
}