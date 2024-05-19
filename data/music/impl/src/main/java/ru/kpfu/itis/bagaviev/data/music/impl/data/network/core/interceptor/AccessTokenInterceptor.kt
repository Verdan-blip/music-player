package ru.kpfu.itis.bagaviev.data.music.impl.data.network.core.interceptor

import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response
import ru.kpfu.itis.bagaviev.data.music.api.data.local.repository.TokenDataRepository
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.core.ApiConfig
import javax.inject.Inject

class AccessTokenInterceptor @Inject constructor(
    private val tokenDataRepository: TokenDataRepository
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = runBlocking {
            tokenDataRepository.getAccessToken()?.let { accessToken ->
                chain.request()
                    .newBuilder()
                    .addHeader(ApiConfig.HEADER_AUTHORIZATION, "Bearer $accessToken")
                    .build()
            } ?: chain.request()
        }
        return chain.proceed(request)
    }
}