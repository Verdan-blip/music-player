package ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.playlist

import android.net.Uri
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.author.AuthorModel
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.track.TrackModel
import java.util.Date

@Parcelize
data class PlaylistDetailsModel(
    val id: Long,
    val title: String,
    val author: AuthorModel,
    val coverUri: Uri,
    val tracks: List<TrackModel>,
    val createdTime: Date,
    val playsCount: Int
): Parcelable