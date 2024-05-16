package ru.kpfu.itis.bagaviev.data.music.impl.data.network.search.di

import dagger.Binds
import dagger.Module
import ru.kpfu.itis.bagaviev.data.music.api.data.network.search.repository.SearchDataRepository
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.search.repository.SearchDataRepositoryImpl
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.search.service.SearchApiService
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.search.service.mocked.MockedSearchApiService

@Module
internal interface MusicSearchDataModule {

    @Binds
    fun provideSearchDataRepositoryImpl_to_SearchDataRepository(
        searchDataRepositoryImpl: SearchDataRepositoryImpl
    ): SearchDataRepository

    @Binds
    fun provideMockedSearchApiService_to_SearchApiService(
        mockedSearchApiService: MockedSearchApiService
    ): SearchApiService
}