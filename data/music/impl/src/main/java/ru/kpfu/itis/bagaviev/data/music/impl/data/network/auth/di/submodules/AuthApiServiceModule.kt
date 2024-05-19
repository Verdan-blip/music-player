package ru.kpfu.itis.bagaviev.data.music.impl.data.network.auth.di.submodules

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.auth.service.AuthApiService
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.core.di.retrofit.PublicRetrofit

@Module
class AuthApiServiceModule {

    @Provides
    fun provideAuthApiService(@PublicRetrofit retrofit: Retrofit): AuthApiService =
        retrofit.create(AuthApiService::class.java)
}