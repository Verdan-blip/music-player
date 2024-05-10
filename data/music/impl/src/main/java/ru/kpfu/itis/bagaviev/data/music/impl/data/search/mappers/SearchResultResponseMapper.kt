package ru.kpfu.itis.bagaviev.data.music.impl.data.search.mappers

import ru.kpfu.itis.bagaviev.data.music.api.data.search.entities.SearchResultDataEntity
import ru.kpfu.itis.bagaviev.data.music.impl.data.playlists.mapper.toPlaylistDataEntity
import ru.kpfu.itis.bagaviev.data.music.impl.data.search.pojo.responses.SearchResultResponse
import ru.kpfu.itis.bagaviev.data.music.impl.data.tracks.mapper.toTrackDataEntity
import ru.kpfu.itis.bagaviev.data.music.impl.data.users.mapper.toUserDataEntity

fun SearchResultResponse.toSearchResultDataEntity(): SearchResultDataEntity =
    SearchResultDataEntity(
        users = users.map { user -> user.toUserDataEntity() },
        tracks = tracks.map { track -> track.toTrackDataEntity() },
        playlists = playlists.map { playlist -> playlist.toPlaylistDataEntity() }
    )