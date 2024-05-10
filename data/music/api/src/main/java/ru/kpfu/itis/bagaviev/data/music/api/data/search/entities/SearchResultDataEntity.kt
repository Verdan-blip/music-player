package ru.kpfu.itis.bagaviev.data.music.api.data.search.entities

import ru.kpfu.itis.bagaviev.data.music.api.data.playlists.entities.PlaylistDataEntity
import ru.kpfu.itis.bagaviev.data.music.api.data.tracks.entities.TrackDataEntity
import ru.kpfu.itis.bagaviev.data.music.api.data.users.entities.UserDataEntity

class SearchResultDataEntity(
    val users: List<UserDataEntity>,
    val tracks: List<TrackDataEntity>,
    val playlists: List<PlaylistDataEntity>
)