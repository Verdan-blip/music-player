package ru.kpfu.itis.bagaviev.feature.signup.di

import android.content.Context
import ru.kpfu.itis.bagaviev.common.di.connector.deps.ComponentDependenciesProvider
import ru.kpfu.itis.bagaviev.common.di.connector.holders.FeatureComponentHolder

object SignUpComponentHolder : FeatureComponentHolder<SignUpComponent>() {

    override fun initComponent(context: Context): SignUpComponent =
        DaggerSignUpComponent.factory().create(
            ComponentDependenciesProvider.get(context)
        )
}