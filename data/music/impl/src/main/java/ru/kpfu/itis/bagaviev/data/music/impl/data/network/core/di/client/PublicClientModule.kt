package ru.kpfu.itis.bagaviev.data.music.impl.data.network.core.di.client

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import ru.kpfu.itis.bagaviev.common.di.scopes.ApplicationScope
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.core.interceptor.StatusCodeInterceptor
import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class PublicClient

@Module
class PublicClientModule {

    @ApplicationScope
    @[Provides PublicClient]
    fun providePublicClient(
        statusCodeInterceptor: StatusCodeInterceptor
    ): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(statusCodeInterceptor)
            .addInterceptor(HttpLoggingInterceptor().apply {
                setLevel(HttpLoggingInterceptor.Level.BODY)
            })
            .addInterceptor(HttpLoggingInterceptor().apply {
                setLevel(HttpLoggingInterceptor.Level.HEADERS)
            })
            .build()
}