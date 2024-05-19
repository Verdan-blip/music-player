package ru.kpfu.itis.bagaviev.data.music.api.data.network.search.entity

import ru.kpfu.itis.bagaviev.data.music.api.data.network.playlist.entity.PlaylistDataEntity
import ru.kpfu.itis.bagaviev.data.music.api.data.network.track.entity.TrackDataEntity
import ru.kpfu.itis.bagaviev.data.music.api.data.network.user.entity.UserDataEntity

class SearchResultDataEntity(
    val users: List<UserDataEntity>,
    val tracks: List<TrackDataEntity>,
    val playlists: List<PlaylistDataEntity>
)