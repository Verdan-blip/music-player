package ru.kpfu.itis.bagaviev.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import ru.kpfu.itis.bagaviev.App
import ru.kpfu.itis.common.di.connector.deps.ComponentDependencies
import ru.kpfu.itis.common.di.keys.ComponentDependenciesKey
import ru.kpfu.itis.oauth.di.OAuthComponentDependencies

@Module
interface DependenciesModule {

    @Binds
    @IntoMap
    @ComponentDependenciesKey(OAuthComponentDependencies::class)
    fun oAuthComponentDependencies(appComponent: AppComponent): ComponentDependencies

    @Binds
    @IntoMap
    @ComponentDependenciesKey(NavigationComponentDependencies::class)
    fun navigationComponentDependencies(appComponent: AppComponent): ComponentDependencies
}