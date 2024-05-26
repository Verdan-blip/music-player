package ru.kpfu.itis.bagaviev.feature.upload.presentation.entity

import java.io.File

data class ClipDataModel(
    val clipFile: File,
    val startMs: Long,
    val endMs: Long
)