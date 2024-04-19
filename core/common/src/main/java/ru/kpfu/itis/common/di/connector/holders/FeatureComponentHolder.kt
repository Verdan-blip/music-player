package ru.kpfu.itis.common.di.connector.holders

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import ru.kpfu.itis.common.di.DiComponent
import ru.kpfu.itis.common.exceptions.ComponentHasNotBeenInitializedException


abstract class FeatureComponentHolder<T : DiComponent> : ComponentHolder<T> {

    protected var component: T? = null

    private var lifecycle: Lifecycle? = null

    private val lifecycleObserver = object : DefaultLifecycleObserver {

        override fun onCreate(owner: LifecycleOwner) {
            buildComponent()
        }

        override fun onDestroy(owner: LifecycleOwner) {
            releaseComponent()
        }
    }

    abstract fun buildComponent()

    fun bind(lifecycle: Lifecycle) {
        this.lifecycle = lifecycle
        lifecycle.addObserver(lifecycleObserver)
    }

    protected open fun releaseComponent() {
        lifecycle?.removeObserver(lifecycleObserver)
        component = null
    }

    override fun requireComponent(): T =
        component ?: throw ComponentHasNotBeenInitializedException()
}