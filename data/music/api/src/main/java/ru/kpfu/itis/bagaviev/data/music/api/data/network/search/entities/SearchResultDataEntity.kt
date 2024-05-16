package ru.kpfu.itis.bagaviev.data.music.api.data.network.search.entities

import ru.kpfu.itis.bagaviev.data.music.api.data.network.playlist.entities.PlaylistDataEntity
import ru.kpfu.itis.bagaviev.data.music.api.data.network.track.entities.TrackDataEntity
import ru.kpfu.itis.bagaviev.data.music.api.data.network.user.entity.UserDataEntity

class SearchResultDataEntity(
    val users: List<UserDataEntity>,
    val tracks: List<TrackDataEntity>,
    val playlists: List<PlaylistDataEntity>
)