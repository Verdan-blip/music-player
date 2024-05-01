package ru.kpfu.itis.bagaviev.impl.di

import dagger.Component
import ru.kpfu.itis.bagaviev.impl.presentation.view.FeedViewModel
import ru.kpfu.itis.common.di.DiComponent
import ru.kpfu.itis.common.di.scopes.FeatureScope

@FeatureScope
@Component(
    dependencies = [FeedComponentDependencies::class],
    modules = [FeedModule::class]
)
interface FeedComponent : DiComponent {

    val viewModelFactory: FeedViewModel.Companion.Factory

    @Component.Factory
    interface Factory {

        fun create(feedComponentDependencies: FeedComponentDependencies): FeedComponent
    }
}