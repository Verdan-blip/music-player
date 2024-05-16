package ru.kpfu.itis.bagaviev.data.music.impl.data.network.auth.pojo.requests

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class LoginRequest(

    @SerialName("login")
    val login: String,

    @SerialName("password")
    val password: String
)