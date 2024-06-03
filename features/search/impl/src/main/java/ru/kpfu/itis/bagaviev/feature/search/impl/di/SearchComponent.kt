package ru.kpfu.itis.bagaviev.feature.search.impl.di

import dagger.Component
import ru.kpfu.itis.bagaviev.common.base.BaseViewModel
import ru.kpfu.itis.bagaviev.common.di.DiComponent
import ru.kpfu.itis.bagaviev.common.di.scopes.FeatureScope

@FeatureScope
@Component(
    dependencies = [SearchComponentDependencies::class],
    modules = [SearchModule::class]
)
interface SearchComponent : DiComponent {

    val viewModelFactory: BaseViewModel.Companion.Factory

    @Component.Factory
    interface Factory {

        fun create(searchComponentDependencies: SearchComponentDependencies): SearchComponent
    }
}