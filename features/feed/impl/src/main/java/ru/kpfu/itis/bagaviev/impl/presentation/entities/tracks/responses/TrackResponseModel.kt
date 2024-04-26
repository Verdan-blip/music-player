package ru.kpfu.itis.bagaviev.feed.domain.tracks.entites.responses

import android.net.Uri
import ru.kpfu.itis.bagaviev.feed.domain.users.response.UserResponseModel

class TrackResponseModel(

    val id: Long,

    val title: String,

    val users: List<UserResponseModel>,

    val smallCoverUri: Uri
)