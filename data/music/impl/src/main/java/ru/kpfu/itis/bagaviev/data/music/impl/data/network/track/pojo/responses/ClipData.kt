package ru.kpfu.itis.bagaviev.data.music.impl.data.network.track.pojo.responses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class ClipData(

    @SerialName("clipFileUri")
    val clipFileUri: String,

    @SerialName("clipStart")
    val clipStart: Long,

    @SerialName("clipEnd")
    val clipEnd: Long
)