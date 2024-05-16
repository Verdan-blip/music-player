package ru.kpfu.itis.bagaviev.data.music.impl.data.network.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.ApiConfig
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.auth.di.AuthDataModule
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.playlist.di.PlaylistDataModule
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.search.di.MusicSearchDataModule
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.track.di.TrackDataModule
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.user.di.UserDataModule

@Module(
    includes = [
        AuthDataModule::class,
        PlaylistDataModule::class,
        MusicSearchDataModule::class,
        TrackDataModule::class,
        UserDataModule::class
    ]
)
class NetworkModule {

    @Provides
    fun provideOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                setLevel(HttpLoggingInterceptor.Level.BODY)
            })
            .build()

    @Provides
    fun provideRetrofit(client: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(ApiConfig.BASE_URL)
            .addConverterFactory(
                Json.asConverterFactory("application/json".toMediaType())
            )
            .client(client)
            .build()
}