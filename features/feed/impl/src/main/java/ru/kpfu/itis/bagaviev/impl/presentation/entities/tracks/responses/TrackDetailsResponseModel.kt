package ru.kpfu.itis.bagaviev.feed.domain.tracks.entites.responses

import android.net.Uri
import java.sql.Timestamp

class TrackDetailsResponseModel(

    val id: Long,

    val title: String,

    val smallCoverUri: Uri,

    val coverUri: Uri,

    val audioFileUri: Uri,

    val releaseTime: Timestamp,

    val playsCount: Int
)