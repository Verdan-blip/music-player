package ru.kpfu.itis.bagaviev.data.music.impl.data.network.auth.pojo.responses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.util.Date

@Serializable
class TokenResponse(

    @SerialName("accessToken")
    val accessToken: String,

    @SerialName("refreshToken")
    val refreshToken: String,

    @SerialName("expiresIn")
    val expiresIn: Int,

    @SerialName("type")
    val type: String
)