package ru.kpfu.itis.bagaviev.data.tracks.entities.responses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.kpfu.itis.bagaviev.data.users.entites.responses.UserResponseEntity

@Serializable
class TrackDetailsResponseEntity(

    @SerialName("id")
    val id: Long,

    @SerialName("title")
    val title: String,

    @SerialName("genre")
    val genre: String,

    @SerialName("lyrics")
    val lyrics: String? = null,

    @SerialName("users")
    val users: List<UserResponseEntity>,

    @SerialName("small_cover_uri")
    val smallCoverUri: String,

    @SerialName("cover_uri")
    val coverUri: String,

    @SerialName("audio_file_uri")
    val audioFileUri: String,

    @SerialName("video_file_uri")
    val videoFileUri: String? = null,

    @SerialName("release_date")
    val releaseDate: String,

    @SerialName("playsCount")
    val playsCount: Int
)