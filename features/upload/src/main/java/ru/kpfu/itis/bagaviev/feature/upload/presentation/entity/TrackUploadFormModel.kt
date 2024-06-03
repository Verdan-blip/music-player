package ru.kpfu.itis.bagaviev.feature.upload.presentation.entity

import java.io.File

data class TrackUploadFormModel(
    val title: String?,
    val genre: String?,
    val authors: List<UserFeedModel>,
    val audioFile: File?,
    val coverFile: File?,
    val smallCoverFile: File?,
    val clipData: ClipDataModel?
)