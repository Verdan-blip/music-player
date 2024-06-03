package ru.kpfu.itis.bagaviev.data.music.impl.data.network.core.di.client

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import ru.kpfu.itis.bagaviev.common.di.scopes.ApplicationScope
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.core.ApiConfig
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.core.authenticator.JwtAuthenticator
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.core.interceptor.AccessTokenInterceptor
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.core.interceptor.StatusCodeInterceptor
import java.util.concurrent.TimeUnit
import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class AuthenticatedClient

@Module
class AuthenticatedClientModule {

    @ApplicationScope
    @[Provides AuthenticatedClient]
    fun provideAuthenticatedClient(
        jwtAuthenticator: JwtAuthenticator,
        accessTokenInterceptor: AccessTokenInterceptor,
        statusCodeInterceptor: StatusCodeInterceptor
    ): OkHttpClient =
        OkHttpClient.Builder()
            .connectTimeout(ApiConfig.CONNECTION_TIMEOUT_MS, TimeUnit.MILLISECONDS)
            .authenticator(jwtAuthenticator)
            .addInterceptor(accessTokenInterceptor)
            .addInterceptor(statusCodeInterceptor)
            .addInterceptor(HttpLoggingInterceptor().apply {
                setLevel(HttpLoggingInterceptor.Level.BODY)
            })
            .addInterceptor(HttpLoggingInterceptor().apply {
                setLevel(HttpLoggingInterceptor.Level.HEADERS)
            })
            .build()
}