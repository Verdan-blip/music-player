package ru.kpfu.itis.bagaviev.data.music.impl.data.network.user.pojo.responses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class UserResponse(

    @SerialName("userId")
    val userId: Long,

    @SerialName("login")
    val login: String,

    @SerialName("avatarUri")
    val avatarUri: String? = null
)