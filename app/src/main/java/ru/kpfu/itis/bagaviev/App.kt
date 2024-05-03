package ru.kpfu.itis.bagaviev

import android.app.Application
import ru.kpfu.itis.bagaviev.di.AppComponent
import ru.kpfu.itis.bagaviev.di.DaggerAppComponent
import ru.kpfu.itis.bagaviev.di.deps.ComponentDependenciesManager
import ru.kpfu.itis.common.di.connector.containers.DependenciesContainer
import ru.kpfu.itis.common.di.connector.deps.ComponentDependencies
import javax.inject.Inject

class App : Application(), DependenciesContainer {

    @Inject lateinit var dependenciesManager: ComponentDependenciesManager

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.factory()
            .create(this)
        appComponent.inject(this)
    }

    override fun <T : ComponentDependencies> getDeps(key: Class<T>): T =
        dependenciesManager.getDependencies(key)
}