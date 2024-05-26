package ru.kpfu.itis.bagaviev.feature.signup.di

import dagger.Component
import ru.kpfu.itis.bagaviev.common.di.DiComponent
import ru.kpfu.itis.bagaviev.common.di.modules.CoroutineDispatcherModule
import ru.kpfu.itis.bagaviev.common.di.scopes.FeatureScope
import ru.kpfu.itis.bagaviev.feature.signup.presentation.view.SignUpViewModel

@FeatureScope
@Component(
    dependencies = [SignUpComponentDependencies::class],
    modules = [SignUpModule::class, CoroutineDispatcherModule::class]
)
interface SignUpComponent : DiComponent {

    val viewModelFactory: SignUpViewModel.Companion.Factory

    @Component.Factory
    interface Factory {

        fun create(
            signUpComponentDependencies: SignUpComponentDependencies
        ): SignUpComponent
    }
}