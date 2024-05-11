package ru.kpfu.itis.bagaviev.feature.search.impl.presentation.entities.search

import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.entities.playlists.PlaylistModel
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.entities.tracks.TrackModel
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.entities.users.UserModel

class SearchResultModel(
    val tracks: List<TrackModel>,
    val playlists: List<PlaylistModel>,
    val users: List<UserModel>
)