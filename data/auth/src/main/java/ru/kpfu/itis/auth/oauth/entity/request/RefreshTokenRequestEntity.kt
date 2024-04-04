package ru.kpfu.itis.auth.oauth.entity.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class RefreshTokenRequestEntity(
    @SerialName("client_id") val clientId: String,
    @SerialName("client_secret") val clientSecret: String,
    @SerialName("grant_type") val grantType: String,
    @SerialName("refresh_token") val refreshToken: String
)