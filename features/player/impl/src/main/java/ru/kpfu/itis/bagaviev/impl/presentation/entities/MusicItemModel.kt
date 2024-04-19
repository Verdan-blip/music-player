package ru.kpfu.itis.bagaviev.impl.presentation.entities

import android.net.Uri

class MusicItemModel(
    val id: Int = -1,
    val title: String = "No title",
    val authors: List<String> = emptyList(),
    val posterUri: Uri = Uri.parse(
        "android.resource://ru.kpfu.itis.bagaviev.player/drawable/music_poster_placeholder"
    ),
    val duration: Long = 0L
)
