package ru.kpfu.itis.bagaviev.player.presentation.entities

import android.net.Uri

class MusicItem(
    val id: Int,
    val title: String,
    val authors: List<String>,
    val fileUri: Uri,
    val posterUri: Uri
)
