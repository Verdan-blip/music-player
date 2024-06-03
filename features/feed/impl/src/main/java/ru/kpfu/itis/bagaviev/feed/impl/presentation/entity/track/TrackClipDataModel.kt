package ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.track

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TrackClipDataModel(
    val clipUri: String,
    val clipStart: Long,
    val clipEnd: Long
) : Parcelable