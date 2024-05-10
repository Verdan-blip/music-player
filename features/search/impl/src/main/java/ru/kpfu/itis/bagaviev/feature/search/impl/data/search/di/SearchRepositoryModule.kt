package ru.kpfu.itis.bagaviev.feature.search.impl.data.search.di

import dagger.Binds
import dagger.Module
import ru.kpfu.itis.bagaviev.feature.search.api.domain.search.repository.SearchRepository
import ru.kpfu.itis.bagaviev.feature.search.impl.data.search.repository.SearchRepositoryImpl

@Module
interface SearchRepositoryModule {

    @Binds
    fun provideSearchRepositoryImpl_to_SearchRepository(
        searchRepositoryImpl: SearchRepositoryImpl
    ): SearchRepository
}