package ru.kpfu.itis.bagaviev.di.deps

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.kpfu.itis.bagaviev.di.AppComponent
import ru.kpfu.itis.bagaviev.presentation.di.MainActivityComponentDependencies
import ru.kpfu.itis.common.di.connector.deps.ComponentDependencies
import ru.kpfu.itis.common.di.keys.ComponentDependenciesKey

@Module
interface MainDependenciesModule {

    @Binds
    @IntoMap
    @ComponentDependenciesKey(MainActivityComponentDependencies::class)
    fun mainActivityComponentDependencies(appComponent: AppComponent): ComponentDependencies
}