package ru.kpfu.itis.bagaviev

import android.app.Application
import ru.kpfu.itis.bagaviev.di.DaggerAppComponent
import ru.kpfu.itis.bagaviev.di.deps.ComponentDependenciesManager
import ru.kpfu.itis.common.di.connector.containers.DependenciesContainer
import ru.kpfu.itis.common.di.connector.deps.ComponentDependencies
import javax.inject.Inject

class App : Application(), DependenciesContainer {

    @Inject lateinit var dependenciesManager: ComponentDependenciesManager

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.factory()
            .create(this)
            .inject(this)
    }

    override fun <T : ComponentDependencies> getDeps(key: Class<T>): T =
        dependenciesManager.getDependencies(key)
}