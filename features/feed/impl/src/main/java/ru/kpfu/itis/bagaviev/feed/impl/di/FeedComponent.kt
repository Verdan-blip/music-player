package ru.kpfu.itis.bagaviev.feed.impl.di

import dagger.Component
import ru.kpfu.itis.bagaviev.common.di.DiComponent
import ru.kpfu.itis.bagaviev.common.di.scopes.FeatureScope
import ru.kpfu.itis.bagaviev.feed.impl.presentation.view.FeedViewModel

@FeatureScope
@Component(
    dependencies = [FeedComponentDependencies::class],
    modules = [
        FeedModule::class
    ]
)
interface FeedComponent : DiComponent {

    val viewModelFactory: FeedViewModel.Companion.Factory

    @Component.Factory
    interface Factory {

        fun create(feedComponentDependencies: FeedComponentDependencies): FeedComponent
    }
}