package ru.kpfu.itis.bagaviev.di

import dagger.BindsInstance
import dagger.Component
import ru.kpfu.itis.bagaviev.App
import ru.kpfu.itis.bagaviev.common.base.BaseViewModel
import ru.kpfu.itis.bagaviev.common.di.scopes.ApplicationScope
import ru.kpfu.itis.bagaviev.di.deps.FeatureComponentsDependencies
import ru.kpfu.itis.bagaviev.navigation.presentation.view.MainFragment
import ru.kpfu.itis.bagaviev.presentation.view.MainActivity

@ApplicationScope
@Component(
    modules = [
        AppModule::class
    ]
)
interface AppComponent : FeatureComponentsDependencies {

    val mainActivityViewModelFactory: BaseViewModel.Companion.Factory

    fun inject(application: App)

    fun inject(mainActivity: MainActivity)

    fun inject(mainFragment: MainFragment)

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance application: App
        ): AppComponent
    }
}