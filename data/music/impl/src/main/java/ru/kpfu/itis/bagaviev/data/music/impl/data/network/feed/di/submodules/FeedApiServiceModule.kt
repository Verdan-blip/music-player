package ru.kpfu.itis.bagaviev.data.music.impl.data.network.feed.di.submodules

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.core.di.retrofit.PublicRetrofit
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.feed.service.FeedApiService

@Module
class FeedApiServiceModule {

    @Provides
    fun provideFeedApiService(@PublicRetrofit retrofit: Retrofit): FeedApiService =
        retrofit.create(FeedApiService::class.java)
}