package ru.kpfu.itis.bagaviev.feature.search.impl.presentation.entities.playlists

import android.net.Uri
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.entities.tracks.TrackModel
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.entities.users.UserModel

data class PlaylistModel(
    val id: Long,
    val title: String,
    val coverUri: Uri,
    val user: UserModel,
    val tracks: List<TrackModel>
)