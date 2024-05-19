package ru.kpfu.itis.bagaviev.data.music.impl.data.network.playlist.di.submodules

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.core.di.retrofit.PublicRetrofit
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.playlist.service.PlaylistApiService

@Module
class PlaylistApiServiceDataModule {

    @Provides
    fun providePlaylistApiService(@PublicRetrofit retrofit: Retrofit): PlaylistApiService =
        retrofit.create(PlaylistApiService::class.java)
}