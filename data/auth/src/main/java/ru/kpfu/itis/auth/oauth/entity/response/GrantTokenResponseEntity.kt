package ru.kpfu.itis.auth.oauth.entity.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class GrantTokenResponseEntity(
    @SerialName("access_token") val accessToken: String,
    @SerialName("expires_in") val expiresIn: Int,
    @SerialName("token_type") val tokenType: String,
    @SerialName("scope") val scope: String,
    @SerialName("refresh_token") val refreshToken: String
)