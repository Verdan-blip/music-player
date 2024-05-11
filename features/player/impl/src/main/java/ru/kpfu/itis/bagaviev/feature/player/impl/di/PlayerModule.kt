package ru.kpfu.itis.bagaviev.feature.player.impl.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.kpfu.itis.bagaviev.common.di.keys.ViewModelKey
import ru.kpfu.itis.bagaviev.common.di.scopes.FeatureScope
import ru.kpfu.itis.bagaviev.feature.player.impl.di.submodules.AndroidPlayerModule
import ru.kpfu.itis.bagaviev.feature.player.impl.presentation.view.PlayerViewModel

@Module(
    includes = [AndroidPlayerModule::class]
)
internal interface PlayerModule {

    @FeatureScope
    @[Binds IntoMap ViewModelKey(PlayerViewModel::class)]
    fun providePlayerViewModel(playerViewModel: PlayerViewModel): ViewModel
}