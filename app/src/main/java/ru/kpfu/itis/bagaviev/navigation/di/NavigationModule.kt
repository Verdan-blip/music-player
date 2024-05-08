package ru.kpfu.itis.bagaviev.navigation.di

import dagger.Module
import dagger.Provides
import ru.kpfu.itis.bagaviev.navigation.Navigator
import ru.kpfu.itis.bagaviev.presentation.GlobalRouter
import ru.kpfu.itis.bagaviev.common.di.scopes.ApplicationScope

@Module
class NavigationModule {

    @ApplicationScope
    @Provides
    fun provideNavigator(): Navigator = Navigator()

    @ApplicationScope
    @Provides
    fun provideGlobalRouter(navigator: Navigator): GlobalRouter = navigator
}