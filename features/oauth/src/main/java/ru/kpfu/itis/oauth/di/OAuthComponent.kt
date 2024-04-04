package ru.kpfu.itis.oauth.di

import dagger.Component
import ru.kpfu.itis.common.di.DiComponent
import ru.kpfu.itis.common.di.modules.CoroutineDispatcherModule
import ru.kpfu.itis.oauth.presentation.OAuthFragment

@Component(
    dependencies = [OAuthComponentDependencies::class],
    modules = [OAuthModule::class, CoroutineDispatcherModule::class]
)
interface OAuthComponent : DiComponent {

    fun inject(oAuthFragment: OAuthFragment)

    @Component.Factory
    interface Factory {
        fun create(oAuthComponentDependencies: OAuthComponentDependencies): OAuthComponent
    }

}