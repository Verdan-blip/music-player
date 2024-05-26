package ru.kpfu.itis.bagaviev.data.music.impl.data.network.user.pojo.responses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class UserCollectionResponse(

    @SerialName("count")
    val count: Int,

    @SerialName("foundUsers")
    val foundUsers: List<UserResponse>
)