package ru.kpfu.itis.bagaviev.data.music.impl.data.network.auth.di.submodules

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.auth.service.AccessTokenApiService
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.core.ApiConfig
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.core.di.retrofit.AuthenticatedRetrofit
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.core.di.retrofit.PublicRetrofit

@Module
class AccessTokenApiServiceModule {

    @Provides
    fun provideTokenService(@PublicRetrofit retrofit: Retrofit): AccessTokenApiService =
        retrofit.create(AccessTokenApiService::class.java)
}