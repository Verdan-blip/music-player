package ru.kpfu.itis.auth.oauth.service

import retrofit2.http.Body
import retrofit2.http.POST
import ru.kpfu.itis.auth.oauth.entity.request.GrantTokenRequestEntity
import ru.kpfu.itis.auth.oauth.entity.request.RefreshTokenRequestEntity
import ru.kpfu.itis.auth.oauth.entity.response.GrantTokenResponseEntity
import ru.kpfu.itis.auth.oauth.entity.response.RefreshTokenResponseEntity

interface JamendoApiOAuthService {

    @POST("v3.0/oauth/grant")
    suspend fun grantAccessToken(
        @Body tokenExchangeRequestEntity: GrantTokenRequestEntity
    ): GrantTokenResponseEntity

    @POST("v3.0/oauth/grant")
    suspend fun refreshAccessToken(
        @Body refreshTokenRequestEntity: RefreshTokenRequestEntity
    ): RefreshTokenResponseEntity

}