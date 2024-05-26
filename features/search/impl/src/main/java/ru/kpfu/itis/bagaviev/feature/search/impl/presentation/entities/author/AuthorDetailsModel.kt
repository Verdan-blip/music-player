package ru.kpfu.itis.bagaviev.feature.search.impl.presentation.entities.author

import android.net.Uri
import ru.kpfu.itis.bagaviev.theme.recyclerview.model.PlaylistRvModel
import ru.kpfu.itis.bagaviev.theme.recyclerview.model.TrackRvModel

class AuthorDetailsModel(
    val id: Long,
    val login: String,
    val avatarUri: Uri,
    val tracks: List<TrackRvModel>,
    val playlists: List<PlaylistRvModel>
)