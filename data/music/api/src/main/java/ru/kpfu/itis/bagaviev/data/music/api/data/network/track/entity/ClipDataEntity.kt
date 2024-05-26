package ru.kpfu.itis.bagaviev.data.music.api.data.network.track.entity

import java.net.URI

class ClipDataEntity(
    val clipFileUri: URI,
    val clipStart: Long,
    val clipEnd: Long
)