package ru.kpfu.itis.bagaviev.player.impl.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.kpfu.itis.bagaviev.player.impl.di.submodules.PlayerAndroidDependenciesModule
import ru.kpfu.itis.bagaviev.player.impl.di.submodules.PlayerInteractorsModule
import ru.kpfu.itis.bagaviev.player.impl.di.submodules.PlayerRepositoriesModule
import ru.kpfu.itis.bagaviev.player.impl.presentation.view.PlayerViewModel
import ru.kpfu.itis.common.di.keys.ViewModelKey
import ru.kpfu.itis.common.di.scopes.FeatureScope

@Module(
    includes = [
        PlayerRepositoriesModule::class,
        PlayerInteractorsModule::class,
        PlayerAndroidDependenciesModule::class
    ]
)
interface PlayerModule {

    @FeatureScope
    @[Binds IntoMap ViewModelKey(PlayerViewModel::class)]
    fun provideOAuthViewModel(playerViewModel: PlayerViewModel): ViewModel
}