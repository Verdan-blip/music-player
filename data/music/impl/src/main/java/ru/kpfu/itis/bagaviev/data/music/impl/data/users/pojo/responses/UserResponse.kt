package ru.kpfu.itis.bagaviev.data.music.impl.data.users.pojo.responses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class UserResponse(

    @SerialName("id")
    val id: Long,

    @SerialName("login")
    val login: String
)