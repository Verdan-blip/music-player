package ru.kpfu.itis.bagaviev.di

import androidx.navigation.NavController
import androidx.navigation.findNavController
import dagger.Module
import dagger.Provides
import ru.kpfu.itis.bagaviev.R
import ru.kpfu.itis.bagaviev.presentation.MainActivity

@Module
class NavigationModule {

    @Provides
    fun provideNavigationController(activity: MainActivity): NavController =
        activity.findNavController(R.id.fv_container)
}