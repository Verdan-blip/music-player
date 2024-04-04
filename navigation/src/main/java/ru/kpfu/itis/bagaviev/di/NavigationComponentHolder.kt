package ru.kpfu.itis.bagaviev.di

import ru.kpfu.itis.bagaviev.presentation.MainActivity

object NavigationComponentHolder {

    private var component: NavigationComponent? = null

    fun get(activity: MainActivity): NavigationComponent =
        component ?: run {
            buildComponent(activity)
        }.also(::set)

    fun set(component: NavigationComponent) {
        this.component = component
    }

    private fun buildComponent(activity: MainActivity): NavigationComponent =
        DaggerNavigationComponent.builder()
            .provideMainActivity(activity)
            .build()

}