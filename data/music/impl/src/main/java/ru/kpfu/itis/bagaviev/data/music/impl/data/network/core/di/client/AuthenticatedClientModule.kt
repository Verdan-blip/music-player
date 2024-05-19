package ru.kpfu.itis.bagaviev.data.music.impl.data.network.core.di.client

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import ru.kpfu.itis.bagaviev.common.di.scopes.ApplicationScope
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.core.authenticator.JwtAuthenticator
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.core.interceptor.AccessTokenInterceptor
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
        accessTokenInterceptor: AccessTokenInterceptor
    ): OkHttpClient =
        OkHttpClient.Builder()
            .authenticator(jwtAuthenticator)
            .addInterceptor(accessTokenInterceptor)
            .addInterceptor(HttpLoggingInterceptor().apply {
                setLevel(HttpLoggingInterceptor.Level.BODY)
            })
            .addInterceptor(HttpLoggingInterceptor().apply {
                setLevel(HttpLoggingInterceptor.Level.HEADERS)
            })
            .build()
}