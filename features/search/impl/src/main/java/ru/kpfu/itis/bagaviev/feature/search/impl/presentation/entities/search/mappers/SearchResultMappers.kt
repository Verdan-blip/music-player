package ru.kpfu.itis.bagaviev.feature.search.impl.presentation.entities.search.mappers

import ru.kpfu.itis.bagaviev.feature.search.api.domain.search.entity.SearchResult
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.entities.playlists.mappers.toPlaylistModel
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.entities.search.SearchResultModel
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.entities.tracks.mappers.toTrackModel
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.entities.users.mappers.toUserModel

fun SearchResult.toSearchResultModel(): SearchResultModel = SearchResultModel(
    tracks = tracks.map { track -> track.toTrackModel() },
    playlists = playlists.map { playlist -> playlist.toPlaylistModel() },
    users = users.map { user -> user.toUserModel() }
)