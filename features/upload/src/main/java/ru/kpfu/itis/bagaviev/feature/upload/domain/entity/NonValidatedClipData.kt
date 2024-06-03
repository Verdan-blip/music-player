package ru.kpfu.itis.bagaviev.feature.upload.domain.entity

import java.io.File

data class NonValidatedClipData(
    val clipFile: File?,
    val startMs: Long?,
    val endMs: Long?
)