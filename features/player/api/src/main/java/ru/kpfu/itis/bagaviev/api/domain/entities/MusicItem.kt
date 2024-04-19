package ru.kpfu.itis.bagaviev.api.domain.entities

import java.net.URI

class MusicItem(
    val id: Int,
    val title: String,
    val authors: List<String>,
    val duration: Long,
    val posterUri: URI,
    val fileUri: URI
)