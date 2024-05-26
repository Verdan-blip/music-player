package ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.track

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.author.AuthorModel
import java.util.Date

@Parcelize
class TrackDetailsModel(
    val id: Long,
    val title: String,
    val genre: String,
    val users: List<AuthorModel>,
    val smallCoverUri: String,
    val coverUri: String,
    val audioFileUri: String,
    val releaseDate: Date,
    val playsCount: Int
): Parcelable