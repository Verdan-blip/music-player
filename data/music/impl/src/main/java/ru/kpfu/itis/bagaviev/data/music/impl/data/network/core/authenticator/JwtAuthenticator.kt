package ru.kpfu.itis.bagaviev.data.music.impl.data.network.core.authenticator

import kotlinx.coroutines.runBlocking
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import ru.kpfu.itis.bagaviev.data.music.api.data.local.token.repository.TokenDataRepository
import ru.kpfu.itis.bagaviev.data.music.api.data.network.auth.entity.TokenDataEntity
import ru.kpfu.itis.bagaviev.data.music.api.data.network.auth.repository.AuthDataRepository
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.core.ApiConfig
import javax.inject.Inject

class JwtAuthenticator @Inject constructor(
    private val tokenDataRepository: TokenDataRepository,
    private val authDataRepository: AuthDataRepository
) : Authenticator {

    private fun refreshAccessToken(refreshToken: String?): TokenDataEntity? {
        val tokenData = refreshToken?.let { token ->
            runBlocking {
                authDataRepository.getAccessToken(token)
            }
        }
        return tokenData
    }

    override fun authenticate(route: Route?, response: Response): Request? {
        val savedAccessToken = runBlocking {
            tokenDataRepository.getAccessToken()
        }
        synchronized(this) {
            val updatedAccessToken = runBlocking {
                tokenDataRepository.getAccessToken()
            }
            val accessToken = if (savedAccessToken != updatedAccessToken) {
                updatedAccessToken
            } else {
                tokenDataRepository.getRefreshToken()?.let { refreshToken ->
                    refreshAccessToken(refreshToken)?.accessToken
                }
            }
            return accessToken?.let { token ->
                response.request.newBuilder()
                    .header(ApiConfig.HEADER_AUTHORIZATION, "Bearer $token")
                    .build()
            }
        }
    }
}