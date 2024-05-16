package ru.kpfu.itis.bagaviev.feature.profile.di

import dagger.Component
import ru.kpfu.itis.bagaviev.common.di.DiComponent
import ru.kpfu.itis.bagaviev.common.di.modules.CoroutineDispatcherModule
import ru.kpfu.itis.bagaviev.common.di.scopes.FeatureScope
import ru.kpfu.itis.bagaviev.feature.profile.presentation.view.ProfileViewModel

@FeatureScope
@Component(
    dependencies = [ProfileComponentDependencies::class],
    modules = [
        ProfileModule::class,
        CoroutineDispatcherModule::class
    ]
)
interface ProfileComponent : DiComponent {

    val viewModelFactory: ProfileViewModel.Companion.Factory

    @Component.Factory
    interface Factory {

        fun create(
            profileComponentDependencies: ProfileComponentDependencies
        ): ProfileComponent
    }
}