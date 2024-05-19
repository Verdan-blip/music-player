package ru.kpfu.itis.bagaviev.data.music.impl.data.network.search.di.submodules

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.core.di.retrofit.PublicRetrofit
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.search.service.SearchApiService

@Module
class SearchApiServiceDataModule {

    @Provides
    fun provideSearchApiService(@PublicRetrofit retrofit: Retrofit) =
        retrofit.create(SearchApiService::class.java)
}