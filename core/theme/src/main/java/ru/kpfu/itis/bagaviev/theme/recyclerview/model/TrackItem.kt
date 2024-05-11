package ru.kpfu.itis.bagaviev.theme.recyclerview.model

import android.net.Uri

sealed class TrackState {

    data object Static : TrackState()

    data class MarkedAsPlaying(val progress: Int) : TrackState()

    data class MarkedAsPaused(val progress: Int) : TrackState()
}

data class TrackItem(
    val id: Long,
    val title: String,
    val users: List<String>,
    val smallCoverUri: Uri
)