package ru.kpfu.itis.bagaviev.api.domain.entities

import java.net.URI
import java.util.Date

class MusicItem(
    val id: Long,
    val title: String,
    val authors: List<String>,
    val genre: String,
    val audioFileUri: URI,
    val coverUri: URI
)