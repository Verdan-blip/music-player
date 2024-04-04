package ru.kpfu.itis.bagaviev.glue.oauth

import ru.kpfu.itis.oauth.domain.repository.AuthTokenRepository
import javax.inject.Inject

class AdapterAuthTokenRepository @Inject constructor(
    private val authTokenRepository: ru.kpfu.itis.auth.token.repository.AuthTokenRepository
) : AuthTokenRepository {

    override suspend fun saveAccessToken(accessToken: String) {
        authTokenRepository.saveAccessToken(accessToken)
    }

    override suspend fun getAccessToken(): String? =
        authTokenRepository.getAccessToken()

}