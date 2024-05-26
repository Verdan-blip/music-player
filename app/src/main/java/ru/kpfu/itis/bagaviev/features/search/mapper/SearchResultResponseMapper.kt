package ru.kpfu.itis.bagaviev.features.search.mapper

import ru.kpfu.itis.bagaviev.data.music.api.data.network.search.entity.SearchResultDataEntity
import ru.kpfu.itis.bagaviev.feature.search.api.domain.search.entity.SearchResult

fun SearchResultDataEntity.toSearchResult(): SearchResult = SearchResult(
    authors = users.map { user -> user.toUser() },
    tracks = tracks.map { track -> track.toTrack() },
    playlists = playlists.map { playlist -> playlist.toPlaylist() }
)