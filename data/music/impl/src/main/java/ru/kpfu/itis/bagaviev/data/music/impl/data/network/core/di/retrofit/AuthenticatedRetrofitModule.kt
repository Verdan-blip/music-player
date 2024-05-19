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
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.core.di.client.AuthenticatedClient
import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class AuthenticatedRetrofit

@Module
class AuthenticatedRetrofitModule {

    @ApplicationScope
    @[Provides AuthenticatedRetrofit]
    fun provideAuthenticatedRetrofit(@AuthenticatedClient client: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(ApiConfig.BASE_URL)
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .client(client)
            .build()
}