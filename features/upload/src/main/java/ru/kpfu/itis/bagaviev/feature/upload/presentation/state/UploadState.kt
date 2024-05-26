package ru.kpfu.itis.bagaviev.feature.upload.presentation.state

import android.net.Uri
import ru.kpfu.itis.bagaviev.feature.upload.presentation.entity.UserModel

data class UploadState(
    val coverUri: Uri? = null,
    val smallCoverUri: Uri? = null,
    val audioUri: Uri? = null,
    val videoUri: Uri? = null
)