package ru.kpfu.itis.common.di.connector.holders

import android.content.Context
import ru.kpfu.itis.common.di.DiComponent

abstract class FeatureComponentHolder<T : DiComponent> : ComponentHolder<T> {

    private var component: T? = null

    override fun get(context: Context): T =
        component ?: run {
            createComponent(context)
        }.also(::set)

    override fun set(component: T) {
        this.component = component
    }

    protected abstract fun createComponent(context: Context): T

}