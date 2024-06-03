package ru.kpfu.itis.bagaviev.feed.impl.di

import dagger.Component
import ru.kpfu.itis.bagaviev.common.base.BaseViewModel
import ru.kpfu.itis.bagaviev.common.di.DiComponent
import ru.kpfu.itis.bagaviev.common.di.scopes.FeatureScope

@FeatureScope
@Component(
    dependencies = [FeedComponentDependencies::class],
    modules = [
        FeedModule::class
    ]
)
interface FeedComponent : DiComponent {

    val viewModelFactory: BaseViewModel.Companion.Factory

    @Component.Factory
    interface Factory {

        fun create(feedComponentDependencies: FeedComponentDependencies): FeedComponent
    }
}