package ru.kpfu.itis.bagaviev.feature.search.impl.di

import dagger.Component
import ru.kpfu.itis.bagaviev.common.di.DiComponent

@Component(
    dependencies = [SearchComponentDependencies::class]
)
interface SearchComponent : DiComponent {

    @Component.Factory
    interface Factory {

        fun create(searchComponentDependencies: SearchComponentDependencies): SearchComponent
    }
}