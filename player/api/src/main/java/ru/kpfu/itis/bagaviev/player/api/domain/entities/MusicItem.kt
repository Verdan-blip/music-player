package ru.kpfu.itis.bagaviev.player.api.domain.entities

import java.net.URI

class MusicItem(
    val id: Long,
    val title: String,
    val authors: List<String>,
    val genre: String,
    val audioFileUri: URI,
    val videoFileUri: URI? = null,
    val coverUri: URI
)