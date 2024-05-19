package ru.kpfu.itis.bagaviev.feature.search.impl.data.search.mappers

import ru.kpfu.itis.bagaviev.data.music.api.data.network.search.entity.SearchResultDataEntity
import ru.kpfu.itis.bagaviev.feature.search.api.domain.search.entity.SearchResult
import ru.kpfu.itis.bagaviev.feature.search.impl.data.playlist.mappers.toPlaylist
import ru.kpfu.itis.bagaviev.feature.search.impl.data.tracks.mappers.toTrack
import ru.kpfu.itis.bagaviev.feature.search.impl.data.users.mappers.toUser

fun SearchResultDataEntity.toSearchResult(): SearchResult = SearchResult(
    users = users.map { user -> user.toUser() },
    tracks = tracks.map { track -> track.toTrack() },
    playlists = playlists.map { playlist -> playlist.toPlaylist() }
)