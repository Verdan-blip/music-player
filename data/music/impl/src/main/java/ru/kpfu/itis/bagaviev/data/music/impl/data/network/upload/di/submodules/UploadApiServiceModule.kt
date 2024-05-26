package ru.kpfu.itis.bagaviev.data.music.impl.data.network.upload.di.submodules

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.core.di.retrofit.AuthenticatedRetrofit
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.upload.service.TrackUploadApiService

@Module
class UploadApiServiceModule {

    @Provides
    fun provideUploadApiService(
        @AuthenticatedRetrofit retrofit: Retrofit
    ): TrackUploadApiService =
        retrofit.create(TrackUploadApiService::class.java)
}