package ru.kpfu.itis.bagaviev.data.music.api.data.network.upload.entity

import ru.kpfu.itis.bagaviev.data.music.api.data.network.user.entity.UserDataEntity
import java.io.File

data class TrackUploadFormDataEntity(
    val title: String,
    val genre: String,
    val lyrics: String? = null,
    val users: List<UserDataEntity>,
    val coverFile: File,
    val smallCoverFile: File?,
    val audioFile: File,
    val clipData: ClipFormDataEntity? = null
)