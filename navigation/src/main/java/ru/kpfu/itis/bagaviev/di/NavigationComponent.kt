package ru.kpfu.itis.bagaviev.di

import dagger.BindsInstance
import dagger.Component
import ru.kpfu.itis.bagaviev.presentation.MainActivity
import ru.kpfu.itis.common.di.DiComponent

@Component(
    modules = [NavigationModule::class]
)
interface NavigationComponent : DiComponent {

    fun inject(activity: MainActivity)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun provideMainActivity(
            activity: MainActivity
        ): Builder

        fun build(): NavigationComponent
    }
}