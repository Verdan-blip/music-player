package ru.kpfu.itis.bagaviev.data.music.impl.data.network.auth.di.submodules

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.auth.service.AccessTokenApiService
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.auth.service.RefreshTokenApiService
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.core.di.retrofit.PublicRetrofit

@Module
class RefreshTokenApiServiceModule {

    @Provides
    fun provideTokenService(@PublicRetrofit retrofit: Retrofit): RefreshTokenApiService =
        retrofit.create(RefreshTokenApiService::class.java)
}