package ru.kpfu.itis.oauth.di

import android.annotation.SuppressLint
import android.content.Context
import ru.kpfu.itis.common.di.connector.deps.ComponentDependenciesProvider
import ru.kpfu.itis.common.di.connector.holders.FeatureComponentHolder

@SuppressLint("StaticFieldLeak")
object OAuthComponentHolder : FeatureComponentHolder<OAuthComponent>() {

    private var context: Context? = null

    fun provideContext(context: Context) {
        this.context = context
    }

    override fun buildComponent() {
        context?.also {
            component = DaggerOAuthComponent.factory().create(
                ComponentDependenciesProvider.get(it)
            )
        }
    }

    override fun releaseComponent() {
        super.releaseComponent()
        context = null
    }
}