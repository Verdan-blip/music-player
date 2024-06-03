package ru.kpfu.itis.bagaviev.feature.upload.presentation.state

import java.io.File

data class MediaUploadState(
    val title: String? = null,
    val genre: String? = null,
    val coverFile: File? = null,
    val smallCoverFile: File? = null,
    val audioFile: File? = null,
    val videoFile: File? = null,
    val clipStartMs: Long? = null,
    val clipEndMs: Long? = null
)