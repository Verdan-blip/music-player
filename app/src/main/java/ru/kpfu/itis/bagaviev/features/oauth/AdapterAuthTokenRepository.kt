package ru.kpfu.itis.bagaviev.features.oauth

import ru.kpfu.itis.bagaviev.data.music.api.data.local.repository.TokenDataRepository
import ru.kpfu.itis.oauth.domain.repository.AuthTokenRepository
import javax.inject.Inject

class AdapterAuthTokenRepository @Inject constructor(
    private val tokenDataRepository: TokenDataRepository
) : AuthTokenRepository {

    override suspend fun saveAccessToken(accessToken: String) {
        tokenDataRepository.saveAccessToken(accessToken)
    }

    override suspend fun getAccessToken(): String? =
        tokenDataRepository.getAccessToken()

}