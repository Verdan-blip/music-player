package ru.kpfu.itis.bagaviev.data.music.impl.data.network.core.di.retrofit

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import ru.kpfu.itis.bagaviev.common.di.scopes.ApplicationScope
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.core.ApiConfig
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.core.di.client.PublicClient
import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class PublicRetrofit

@Module
class PublicRetrofitModule {

    @ApplicationScope
    @[Provides PublicRetrofit]
    fun providePublicRetrofit(@PublicClient client: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(ApiConfig.BASE_URL)
            .client(client)
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .build()
}