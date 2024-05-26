package ru.kpfu.itis.bagaviev.feature.upload.presentation.state

import android.net.Uri

data class UploadState(
    val coverUri: Uri? = null,
    val smallCoverUri: Uri? = null,
    val audioUri: Uri? = null,
    val videoUri: Uri? = null
)