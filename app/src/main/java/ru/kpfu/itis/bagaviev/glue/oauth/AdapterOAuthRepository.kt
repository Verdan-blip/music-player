package ru.kpfu.itis.bagaviev.glue.oauth

import ru.kpfu.itis.auth.oauth.repository.OAuthDataRepository
import ru.kpfu.itis.oauth.domain.entities.GrantedTokenData
import ru.kpfu.itis.oauth.domain.repository.OAuthRepository
import java.net.URI
import javax.inject.Inject

class AdapterOAuthRepository @Inject constructor(
    private val oAuthDataRepository: OAuthDataRepository
) : OAuthRepository {

    override suspend fun getOAuthUri(): URI =
        oAuthDataRepository.getOAuthUri()

    override suspend fun getGrantedTokenData(code: String): GrantedTokenData =
        with (oAuthDataRepository.grantAccessToken(code)) {
            GrantedTokenData(
                refreshToken = refreshToken,
                accessToken = accessToken
            )
        }

}