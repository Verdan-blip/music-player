package ru.kpfu.itis.bagaviev.di

import android.content.Context
import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.kpfu.itis.bagaviev.App
import ru.kpfu.itis.bagaviev.common.di.keys.ViewModelKey
import ru.kpfu.itis.bagaviev.data.music.impl.di.DataModule
import ru.kpfu.itis.bagaviev.di.deps.FeatureDependenciesModule
import ru.kpfu.itis.bagaviev.features.FeaturesModule
import ru.kpfu.itis.bagaviev.navigation.di.NavigationModule
import ru.kpfu.itis.bagaviev.player.impl.di.PlayerModule
import ru.kpfu.itis.bagaviev.presentation.di.MainActivityModule
import ru.kpfu.itis.bagaviev.presentation.view.MainActivityViewModel

@Module(
    includes = [
        NavigationModule::class,
        PlayerModule::class,
        FeatureDependenciesModule::class,
        FeaturesModule::class,
        DataModule::class,
        MainActivityModule::class
    ]
)
interface AppModule {

    @[Binds IntoMap ViewModelKey(MainActivityViewModel::class)]
    fun provideMainActivityViewModel(mainActivityViewModel: MainActivityViewModel): ViewModel

    @Binds
    fun provideContext(application: App): Context
}