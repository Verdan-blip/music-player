package ru.kpfu.itis.bagaviev.feature.player.impl.di

import dagger.Component
import ru.kpfu.itis.bagaviev.common.di.DiComponent
import ru.kpfu.itis.bagaviev.common.di.scopes.FeatureScope
import ru.kpfu.itis.bagaviev.feature.player.impl.presentation.view.PlayerFragment
import ru.kpfu.itis.bagaviev.feature.player.impl.presentation.view.PlayerViewModel

@FeatureScope
@Component(
    modules = [PlayerModule::class],
    dependencies = [PlayerComponentDependencies::class]
)
interface PlayerComponent : DiComponent{

    val viewModelFactory: PlayerViewModel.Companion.Factory

    fun inject(playerFragment: PlayerFragment)

    @Component.Factory
    interface Factory {

        fun create(dependencies: PlayerComponentDependencies): PlayerComponent
    }
}