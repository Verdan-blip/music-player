package ru.kpfu.itis.bagaviev.data.music.impl.data.network.auth.pojo.requests

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RefreshRequest(

    @SerialName("refreshToken")
    val refreshToken: String
)