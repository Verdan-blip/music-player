package ru.kpfu.itis.bagaviev.feature.search.impl.presentation.view.state

import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.entities.playlists.PlaylistModel
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.entities.tracks.TrackModel
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.entities.users.UserModel

data class SearchUiState(
    val foundTracks: List<TrackModel>,
    val foundPlaylists: List<PlaylistModel>,
    val foundUsers: List<UserModel>
)