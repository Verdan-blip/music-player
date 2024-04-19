package ru.kpfu.itis.bagaviev.glue.oauth

import ru.kpfu.itis.auth.token.repository.AuthTokenDataRepository
import ru.kpfu.itis.oauth.domain.repository.AuthTokenRepository
import javax.inject.Inject

class AdapterAuthTokenRepository @Inject constructor(
    private val authTokenDataRepository: AuthTokenDataRepository
) : AuthTokenRepository {

    override suspend fun saveAccessToken(accessToken: String) {
        authTokenDataRepository.saveAccessToken(accessToken)
    }

    override suspend fun getAccessToken(): String? =
        authTokenDataRepository.getAccessToken()

}