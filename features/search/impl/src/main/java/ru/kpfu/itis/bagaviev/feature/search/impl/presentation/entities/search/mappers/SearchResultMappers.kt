package ru.kpfu.itis.bagaviev.feature.search.impl.presentation.entities.search.mappers

import ru.kpfu.itis.bagaviev.feature.search.api.domain.search.entity.SearchResult
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.entities.author.mappers.toAuthorModel
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.entities.playlist.mappers.toPlaylistModel
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.entities.search.SearchResultModel
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.entities.track.mappers.toTrackModel

fun SearchResult.toSearchResultModel(): SearchResultModel = SearchResultModel(
    tracks = tracks.map { track -> track.toTrackModel() },
    playlists = playlists.map { playlist -> playlist.toPlaylistModel() },
    users = authors.map { user -> user.toAuthorModel() }
)