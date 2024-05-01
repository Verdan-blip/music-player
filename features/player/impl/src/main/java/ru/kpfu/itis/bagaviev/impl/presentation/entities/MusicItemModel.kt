package ru.kpfu.itis.bagaviev.impl.presentation.entities

import android.net.Uri

class MusicItemModel(
    val id: Long,
    val title: String,
    val authors: List<String>,
    val coverUri: Uri
)
