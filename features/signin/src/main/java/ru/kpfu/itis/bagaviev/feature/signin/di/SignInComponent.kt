package ru.kpfu.itis.bagaviev.feature.signin.di

import dagger.Component
import ru.kpfu.itis.bagaviev.common.di.DiComponent
import ru.kpfu.itis.bagaviev.common.di.modules.CoroutineDispatcherModule
import ru.kpfu.itis.bagaviev.common.di.scopes.FeatureScope
import ru.kpfu.itis.bagaviev.feature.signin.presentation.view.SignInViewModel

@FeatureScope
@Component(
    dependencies = [SignInComponentDependencies::class],
    modules = [
        SignInModule::class,
        CoroutineDispatcherModule::class
    ]
)
interface SignInComponent : DiComponent {

    val viewModelFactory: SignInViewModel.Companion.Factory

    @Component.Factory
    interface Factory {

        fun create(
            signInComponentDependencies: SignInComponentDependencies
        ): SignInComponent
    }
}