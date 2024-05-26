package ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.track

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TrackModel(
    val id: Long,
    val title: String,
    val smallCoverUri: String,
    val authorNames: List<String>
) : Parcelable