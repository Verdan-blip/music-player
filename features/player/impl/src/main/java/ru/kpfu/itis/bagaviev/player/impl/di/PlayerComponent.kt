package ru.kpfu.itis.bagaviev.player.impl.di

import dagger.Component
import ru.kpfu.itis.bagaviev.player.impl.presentation.view.PlayerFragment
import ru.kpfu.itis.bagaviev.player.impl.presentation.view.PlayerViewModel
import ru.kpfu.itis.common.di.DiComponent
import ru.kpfu.itis.common.di.scopes.FeatureScope

@FeatureScope
@Component(
    modules = [PlayerModule::class],
    dependencies = [PlayerComponentDependencies::class]
)
interface PlayerComponent : DiComponent {

    val viewModelFactory: PlayerViewModel.Companion.Factory

    fun inject(playerFragment: PlayerFragment)

    @Component.Factory
    interface Factory {

        fun create(dependencies: PlayerComponentDependencies): PlayerComponent
    }
}