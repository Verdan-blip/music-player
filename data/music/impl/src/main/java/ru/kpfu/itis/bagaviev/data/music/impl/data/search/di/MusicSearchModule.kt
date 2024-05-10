package ru.kpfu.itis.bagaviev.data.music.impl.data.search.di

import dagger.Binds
import dagger.Module
import ru.kpfu.itis.bagaviev.data.music.api.data.search.repository.SearchDataRepository
import ru.kpfu.itis.bagaviev.data.music.impl.data.search.repository.SearchDataRepositoryImpl
import ru.kpfu.itis.bagaviev.data.music.impl.data.search.service.SearchApiService
import ru.kpfu.itis.bagaviev.data.music.impl.data.search.service.mocked.MockedSearchApiService

@Module
internal interface MusicSearchModule {

    @Binds
    fun provideSearchDataRepositoryImpl_to_SearchDataRepository(
        searchDataRepositoryImpl: SearchDataRepositoryImpl
    ): SearchDataRepository

    @Binds
    fun provideMockedSearchApiService_to_SearchApiService(
        mockedSearchApiService: MockedSearchApiService
    ): SearchApiService
}