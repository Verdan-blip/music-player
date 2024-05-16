package ru.kpfu.itis.bagaviev.data.music.impl.data.network.auth.pojo.requests

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class RegisterRequest(

    @SerialName("login")
    val login: String,

    @SerialName("email")
    val email: String,

    @SerialName("password")
    val password: String
)