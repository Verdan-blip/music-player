package ru.kpfu.itis.auth.oauth.repository

import ru.kpfu.itis.auth.oauth.config.OAuthApiConfig
import ru.kpfu.itis.auth.oauth.entity.request.GrantTokenRequestEntity
import ru.kpfu.itis.auth.oauth.entity.request.RefreshTokenRequestEntity
import ru.kpfu.itis.auth.oauth.entity.response.GrantTokenResponseEntity
import ru.kpfu.itis.auth.oauth.entity.response.RefreshTokenResponseEntity
import ru.kpfu.itis.auth.oauth.service.JamendoApiOAuthService
import java.net.URI
import javax.inject.Inject

class JamendoApiAuthRepository @Inject constructor(
    private val jamendoApiOAuthService: JamendoApiOAuthService
) : OAuthRepository {

    override suspend fun getOAuthUri(): URI {
        return URI(
            OAuthApiConfig.SCHEME,
            OAuthApiConfig.AUTHORITY,
            OAuthApiConfig.PATH,
            "client_id=${OAuthApiConfig.CLIENT_ID}" +
                    "&scope=${OAuthApiConfig.SCOPE}" +
                    "&response_type=${OAuthApiConfig.RESPONSE_TYPE}",
            null
        )
    }

    override suspend fun grantAccessToken(code: String): GrantTokenResponseEntity =
        jamendoApiOAuthService.grantAccessToken(
            GrantTokenRequestEntity(
                clientId = OAuthApiConfig.CLIENT_ID,
                clientSecret = OAuthApiConfig.CLIENT_SECRET,
                grantType = OAuthApiConfig.GRAND_TYPE,
                code = code
            )
        )

    override suspend fun refreshAccessToken(refreshToken: String): RefreshTokenResponseEntity =
        jamendoApiOAuthService.refreshAccessToken(
            RefreshTokenRequestEntity(
                clientId = OAuthApiConfig.CLIENT_ID,
                clientSecret = OAuthApiConfig.CLIENT_SECRET,
                grantType = OAuthApiConfig.GRAND_TYPE,
                refreshToken = refreshToken
            )
        )

}