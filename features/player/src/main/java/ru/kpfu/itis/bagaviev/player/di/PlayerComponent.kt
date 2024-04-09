package ru.kpfu.itis.bagaviev.player.di

import dagger.Component
import ru.kpfu.itis.bagaviev.player.presentation.view.PlayerFragment
import ru.kpfu.itis.common.di.DiComponent
import ru.kpfu.itis.common.di.scopes.FeatureScope

@FeatureScope
@Component(
    modules = [PlayerModule::class],
    dependencies = [PlayerComponentDependencies::class]
)
interface PlayerComponent : DiComponent {

    fun inject(playerFragment: PlayerFragment)

    @Component.Factory
    interface Factory {
        fun create(dependencies: PlayerComponentDependencies): PlayerComponent
    }
}