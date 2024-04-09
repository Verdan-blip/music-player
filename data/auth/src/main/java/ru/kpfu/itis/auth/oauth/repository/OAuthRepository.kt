package ru.kpfu.itis.auth.oauth.repository

import ru.kpfu.itis.auth.oauth.entities.response.GrantTokenResponseEntity
import ru.kpfu.itis.auth.oauth.entities.response.RefreshTokenResponseEntity
import java.net.URI

interface OAuthRepository {

    suspend fun getOAuthUri(): URI

    suspend fun grantAccessToken(code: String): GrantTokenResponseEntity

    suspend fun refreshAccessToken(refreshToken: String): RefreshTokenResponseEntity

}