package ru.kpfu.itis.bagaviev.data.music.api.data.network.upload.entity

import java.io.File

data class ClipFormDataEntity(
    val clipFile: File,
    val clipStartMs: Long,
    val clipEndMs: Long
)