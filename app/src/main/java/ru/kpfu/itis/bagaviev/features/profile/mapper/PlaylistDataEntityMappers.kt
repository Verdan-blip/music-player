package ru.kpfu.itis.bagaviev.features.profile.mapper

import ru.kpfu.itis.bagaviev.data.music.api.data.network.playlist.entities.PlaylistDataEntity
import ru.kpfu.itis.bagaviev.feature.profile.domain.entity.playlist.MyPlaylist

fun PlaylistDataEntity.toMyPlaylist(): MyPlaylist = MyPlaylist(
    id = id,
    title = title,
    coverUri = coverUri,
    user = user.toUser(),
    myTracks = tracks.map { track -> track.toMyTrack() }
)