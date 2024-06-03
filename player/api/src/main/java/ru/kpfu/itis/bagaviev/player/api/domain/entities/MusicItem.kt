package ru.kpfu.itis.bagaviev.player.api.domain.entities


class MusicItem(
    val id: Long,
    val title: String,
    val audioFileUri: String,
    val coverUri: String,
    val authors: List<String>,
    val clipData: ClipData? = null
)