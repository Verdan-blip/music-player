package ru.kpfu.itis.bagaviev.glue.oauth

import ru.kpfu.itis.oauth.domain.entities.GrantedTokenData
import ru.kpfu.itis.oauth.domain.repository.OAuthRepository
import java.net.URI
import javax.inject.Inject

class AdapterOAuthRepository @Inject constructor(
    private val oAuthRepository: ru.kpfu.itis.auth.oauth.repository.OAuthRepository
) : OAuthRepository {
    override suspend fun getOAuthUri(): URI =
        oAuthRepository.getOAuthUri()

    override suspend fun getGrantedTokenData(code: String): GrantedTokenData =
        with (oAuthRepository.grantAccessToken(code)) {
            GrantedTokenData(
                refreshToken = refreshToken,
                accessToken = accessToken
            )
        }

}