package ru.kpfu.itis.bagaviev.di.deps

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.kpfu.itis.bagaviev.common.di.connector.deps.ComponentDependencies
import ru.kpfu.itis.bagaviev.common.di.keys.ComponentDependenciesKey
import ru.kpfu.itis.bagaviev.di.AppComponent
import ru.kpfu.itis.bagaviev.feature.player.impl.di.PlayerComponentDependencies
import ru.kpfu.itis.bagaviev.feature.profile.di.ProfileComponentDependencies
import ru.kpfu.itis.bagaviev.feature.search.impl.di.SearchComponentDependencies
import ru.kpfu.itis.bagaviev.feature.signin.di.SignInComponentDependencies
import ru.kpfu.itis.bagaviev.feature.signup.di.SignUpComponentDependencies
import ru.kpfu.itis.bagaviev.feature.upload.di.UploadComponentDependencies
import ru.kpfu.itis.bagaviev.feed.impl.di.FeedComponentDependencies

@Module
interface FeatureDependenciesModule {

    @Binds
    @IntoMap
    @ComponentDependenciesKey(PlayerComponentDependencies::class)
    fun playerComponentDependencies(appComponent: AppComponent): ComponentDependencies

    @Binds
    @IntoMap
    @ComponentDependenciesKey(FeedComponentDependencies::class)
    fun feedComponentDependencies(appComponent: AppComponent): ComponentDependencies

    @Binds
    @IntoMap
    @ComponentDependenciesKey(SearchComponentDependencies::class)
    fun searchComponentDependencies(appComponent: AppComponent): ComponentDependencies

    @Binds
    @IntoMap
    @ComponentDependenciesKey(SignInComponentDependencies::class)
    fun signInComponentDependencies(appComponent: AppComponent): ComponentDependencies

    @Binds
    @IntoMap
    @ComponentDependenciesKey(SignUpComponentDependencies::class)
    fun signUpComponentDependencies(appComponent: AppComponent): ComponentDependencies

    @Binds
    @IntoMap
    @ComponentDependenciesKey(ProfileComponentDependencies::class)
    fun profileComponentDependencies(appComponent: AppComponent): ComponentDependencies

    @Binds
    @IntoMap
    @ComponentDependenciesKey(UploadComponentDependencies::class)
    fun uploadComponentDependencies(appComponent: AppComponent): ComponentDependencies
}