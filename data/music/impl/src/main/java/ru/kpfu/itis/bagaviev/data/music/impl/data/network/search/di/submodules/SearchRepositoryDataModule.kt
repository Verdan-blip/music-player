package ru.kpfu.itis.bagaviev.data.music.impl.data.network.search.di.submodules

import dagger.Binds
import dagger.Module
import ru.kpfu.itis.bagaviev.data.music.api.data.network.search.repository.SearchDataRepository
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.search.repository.SearchDataRepositoryImpl

@Module
interface SearchRepositoryDataModule {

    @Binds
    fun provideSearchDataRepositoryImpl_to_SearchDataRepository(
        searchDataRepositoryImpl: SearchDataRepositoryImpl
    ): SearchDataRepository
}