package ru.kpfu.itis.bagaviev.common.di.connector.holders

import android.content.Context
import ru.kpfu.itis.bagaviev.common.di.DiComponent


abstract class FeatureComponentHolder<T : DiComponent> : ComponentHolder<T> {

    private var component: T? = null

    protected abstract fun initComponent(context: Context): T

    fun createComponent(context: Context): T =
        initComponent(context).also { component = it }

    override fun releaseComponent() {
        component = null
    }
}