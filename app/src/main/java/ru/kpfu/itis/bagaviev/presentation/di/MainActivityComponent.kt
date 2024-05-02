package ru.kpfu.itis.bagaviev.presentation.di

import dagger.Component
import ru.kpfu.itis.bagaviev.presentation.view.MainActivity

@MainActivityScope
@Component(
    modules = [MainActivityModule::class],
    dependencies = [MainActivityComponentDependencies::class]
)
interface MainActivityComponent {

    fun inject(activity: MainActivity)

    @Component.Factory
    interface Factory {

        fun create(
            mainActivityComponentDependencies: MainActivityComponentDependencies
        ): MainActivityComponent
    }
}