package ru.kpfu.itis.bagaviev.di

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.kpfu.itis.bagaviev.player.di.PlayerComponentDependencies
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
    @ComponentDependenciesKey(PlayerComponentDependencies::class)
    fun playerComponentDependencies(appComponent: AppComponent): ComponentDependencies
}