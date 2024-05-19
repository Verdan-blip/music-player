package ru.kpfu.itis.bagaviev.data.music.impl.data.network.track.di.submodules

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.core.di.retrofit.PublicRetrofit
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.track.service.TrackApiService

@Module
class TrackApiServiceModule {

    @Provides
    fun provideTrackApiService(@PublicRetrofit retrofit: Retrofit) =
        retrofit.create(TrackApiService::class.java)
}