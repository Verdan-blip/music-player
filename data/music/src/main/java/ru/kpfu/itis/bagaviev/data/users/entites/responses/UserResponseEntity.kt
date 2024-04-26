package ru.kpfu.itis.bagaviev.data.users.entites.responses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class UserResponseEntity(

    @SerialName("id")
    val id: Long,

    @SerialName("login")
    val login: String
)