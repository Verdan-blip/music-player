package ru.kpfu.itis.bagaviev.feature.upload.domain.entity

import java.io.File

data class TrackUploadForm(
    val title: String,
    val users: List<User>,
    val audioFile: File,
    val coverFile: File,
    val smallCoverFile: File,
    val clipData: ClipData?
)