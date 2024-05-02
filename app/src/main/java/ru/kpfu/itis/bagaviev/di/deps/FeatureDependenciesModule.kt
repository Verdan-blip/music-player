package ru.kpfu.itis.bagaviev.di.deps

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.kpfu.itis.bagaviev.di.AppComponent
import ru.kpfu.itis.bagaviev.feed.impl.di.FeedComponentDependencies
import ru.kpfu.itis.bagaviev.player.impl.di.PlayerComponentDependencies
import ru.kpfu.itis.common.di.connector.deps.ComponentDependencies
import ru.kpfu.itis.common.di.keys.ComponentDependenciesKey
import ru.kpfu.itis.oauth.di.OAuthComponentDependencies

@Module
interface FeatureDependenciesModule {

    @Binds
    @IntoMap
    @ComponentDependenciesKey(OAuthComponentDependencies::class)
    fun oAuthComponentDependencies(appComponent: AppComponent): ComponentDependencies

    @Binds
    @IntoMap
    @ComponentDependenciesKey(PlayerComponentDependencies::class)
    fun playerComponentDependencies(appComponent: AppComponent): ComponentDependencies

    @Binds
    @IntoMap
    @ComponentDependenciesKey(FeedComponentDependencies::class)
    fun feedComponentDependencies(appComponent: AppComponent): ComponentDependencies
}