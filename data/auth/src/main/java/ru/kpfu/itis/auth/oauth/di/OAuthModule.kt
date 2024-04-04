package ru.kpfu.itis.auth.oauth.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import ru.kpfu.itis.auth.oauth.config.OAuthApiConfig
import ru.kpfu.itis.auth.oauth.service.JamendoApiOAuthService

@Module
class OAuthModule {

    @Provides
    fun provideApiService(): JamendoApiOAuthService {
        val client = OkHttpClient.Builder()
            .build()
        val retrofit = Retrofit.Builder()
            .client(client)
            .baseUrl(OAuthApiConfig.AUTH_URL)
            .addConverterFactory(
                Json.asConverterFactory(MediaType.parse("application/json")!!)
            )
            .build()
        return retrofit.create(JamendoApiOAuthService::class.java)
    }
}