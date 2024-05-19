package ru.kpfu.itis.bagaviev.data.music.impl.data.network.search.mappers

import ru.kpfu.itis.bagaviev.data.music.api.data.network.search.entity.SearchResultDataEntity
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.playlist.mapper.toPlaylistDataEntity
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.search.pojo.responses.SearchResultResponse
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.track.mapper.toTrackDataEntity
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.user.mapper.toUserDataEntity

fun SearchResultResponse.toSearchResultDataEntity(): SearchResultDataEntity =
    SearchResultDataEntity(
        users = users.map { user -> user.toUserDataEntity() },
        tracks = tracks.map { track -> track.toTrackDataEntity() },
        playlists = playlists.map { playlist -> playlist.toPlaylistDataEntity() }
    )