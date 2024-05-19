package ru.kpfu.itis.bagaviev.feature.search.impl.di.submodules

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import ru.kpfu.itis.bagaviev.common.di.modules.IODispatcher
import ru.kpfu.itis.bagaviev.feature.search.api.domain.search.repository.SearchRepository
import ru.kpfu.itis.bagaviev.feature.search.api.domain.search.usecase.SearchByKeywordsUseCase

@Module
class SearchUseCaseModule {

    @Provides
    fun provideSearchByKeywords(
        searchRepository: SearchRepository,
        @IODispatcher coroutineDispatcher: CoroutineDispatcher
    ): SearchByKeywordsUseCase =
        SearchByKeywordsUseCase(searchRepository, coroutineDispatcher)
}