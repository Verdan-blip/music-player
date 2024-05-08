package ru.kpfu.itis.bagaviev.di

import dagger.BindsInstance
import dagger.Component
import ru.kpfu.itis.auth.di.DataModule
import ru.kpfu.itis.bagaviev.App
import ru.kpfu.itis.bagaviev.common.di.scopes.ApplicationScope
import ru.kpfu.itis.bagaviev.di.deps.FeatureComponentsDependencies
import ru.kpfu.itis.bagaviev.di.deps.FeatureDependenciesModule
import ru.kpfu.itis.bagaviev.glue.FeaturesModule
import ru.kpfu.itis.bagaviev.presentation.view.MainActivity

@ApplicationScope
@Component(
    modules = [
        AppModule::class,
        FeatureDependenciesModule::class,
        FeaturesModule::class,
        DataModule::class
    ]
)
interface AppComponent : FeatureComponentsDependencies {

    fun inject(application: App)

    fun inject(activity: MainActivity)

    @Component.Factory
    interface Factory {

        fun create(@BindsInstance application: App): AppComponent
    }
}