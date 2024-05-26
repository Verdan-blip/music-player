package ru.kpfu.itis.bagaviev.feature.search.impl.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.kpfu.itis.bagaviev.common.di.keys.ViewModelKey
import ru.kpfu.itis.bagaviev.common.di.scopes.FeatureScope
import ru.kpfu.itis.bagaviev.feature.search.impl.di.submodules.UseCasesModule
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.view.SearchViewModel


@Module(
    includes = [
        UseCasesModule::class
    ]
)
interface SearchModule {

    @FeatureScope
    @[Binds IntoMap ViewModelKey(SearchViewModel::class)]
    fun provideSearchViewModel(searchViewModel: SearchViewModel): ViewModel
}