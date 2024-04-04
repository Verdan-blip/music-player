package ru.kpfu.itis.bagaviev.di

import dagger.BindsInstance
import dagger.Component
import ru.kpfu.itis.auth.di.DataModule
import ru.kpfu.itis.bagaviev.App
import ru.kpfu.itis.bagaviev.glue.FeaturesModule
import ru.kpfu.itis.common.di.connector.deps.ComponentDependencies

@Component(
    modules = [
        AppModule::class,
        DataModule::class,
        DependenciesModule::class,
        FeaturesModule::class
    ]
)
interface AppComponent : ComponentDependencies {

    fun inject(application: App)

    @Component.Factory
    interface Factory {

        fun create(@BindsInstance application: App): AppComponent
    }
}