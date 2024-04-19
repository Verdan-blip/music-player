package ru.kpfu.itis.oauth.di

import dagger.Component
import ru.kpfu.itis.common.di.DiComponent
import ru.kpfu.itis.common.di.modules.CoroutineDispatcherModule
import ru.kpfu.itis.common.di.scopes.FeatureScope
import ru.kpfu.itis.oauth.presentation.OAuthViewModel

@FeatureScope
@Component(
    dependencies = [OAuthComponentDependencies::class],
    modules = [OAuthModule::class, CoroutineDispatcherModule::class]
)
interface OAuthComponent : DiComponent {

    val viewModelFactory: OAuthViewModel.Companion.Factory

    @Component.Factory
    interface Factory {

        fun create(oAuthComponentDependencies: OAuthComponentDependencies): OAuthComponent
    }

}