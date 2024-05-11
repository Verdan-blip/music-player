package ru.kpfu.itis.bagaviev.feature.search.impl.di

import dagger.Component
import ru.kpfu.itis.bagaviev.common.di.DiComponent
import ru.kpfu.itis.bagaviev.common.di.scopes.FeatureScope
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.view.SearchViewModel

@FeatureScope
@Component(
    dependencies = [SearchComponentDependencies::class],
    modules = [SearchModule::class]
)
interface SearchComponent : DiComponent {

    val viewModelFactory: SearchViewModel.Companion.Factory

    @Component.Factory
    interface Factory {

        fun create(searchComponentDependencies: SearchComponentDependencies): SearchComponent
    }
}