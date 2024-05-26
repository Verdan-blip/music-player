package ru.kpfu.itis.bagaviev.feature.search.impl.presentation.entities.search

import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.entities.author.AuthorModel
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.entities.playlist.PlaylistModel
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.entities.track.TrackModel

class SearchResultModel(
    val tracks: List<TrackModel>,
    val playlists: List<PlaylistModel>,
    val users: List<AuthorModel>
)