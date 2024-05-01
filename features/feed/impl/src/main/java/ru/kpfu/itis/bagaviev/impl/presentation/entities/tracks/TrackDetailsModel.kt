package ru.kpfu.itis.bagaviev.impl.presentation.entities.tracks

import android.net.Uri
import ru.kpfu.itis.bagaviev.impl.presentation.entities.users.UserModel
import java.util.Date

class TrackDetailsModel(

    val id: Long,

    val title: String,

    val genre: String,

    val users: List<UserModel>,

    val smallCoverUri: Uri,

    val coverUri: Uri,

    val audioFileUri: Uri,

    val videoFileUri: Uri?,

    val releaseDate: Date,

    val playsCount: Int
)