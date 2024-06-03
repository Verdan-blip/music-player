package ru.kpfu.itis.bagaviev.feature.upload.domain.entity

import java.io.File

class NonValidatedTrackUploadForm(
    val title: String?,
    val genre: String?,
    val authors: List<AuthorFeed>,
    val audioFile: File?,
    val coverFile: File?,
    val smallCoverFile: File?,
    val nonValidatedClipData: NonValidatedClipData?
)