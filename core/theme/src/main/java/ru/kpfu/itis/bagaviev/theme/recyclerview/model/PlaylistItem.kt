package ru.kpfu.itis.bagaviev.theme.recyclerview.model

import android.net.Uri

data class PlaylistItem(
    val id: Long,
    val title: String,
    val coverUri: Uri,
    val user: String,
    val tracks: List<TrackItem>,
    val playingTrackId: Long? = null
)