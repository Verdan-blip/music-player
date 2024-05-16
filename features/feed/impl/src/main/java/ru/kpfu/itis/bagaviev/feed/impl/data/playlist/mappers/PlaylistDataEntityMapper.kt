package ru.kpfu.itis.bagaviev.feed.impl.data.playlist.mappers

import ru.kpfu.itis.bagaviev.data.music.api.data.network.playlist.entities.PlaylistDataEntity
import ru.kpfu.itis.bagaviev.data.music.api.data.network.playlist.entities.PlaylistDetailsDataEntity
import ru.kpfu.itis.bagaviev.feed.api.domain.playlist.entity.Playlist
import ru.kpfu.itis.bagaviev.feed.api.domain.playlist.entity.PlaylistDetails
import ru.kpfu.itis.bagaviev.feed.impl.data.track.mappers.toTrack
import ru.kpfu.itis.bagaviev.feed.impl.data.user.mapper.toUser

fun PlaylistDataEntity.toPlaylist(): Playlist = Playlist(
    id = id,
    title = title,
    coverUri = coverUri,
    user = user.toUser(),
    tracks = tracks.map { track -> track.toTrack() }
)

fun PlaylistDetailsDataEntity.toPlaylistDetails(): PlaylistDetails = PlaylistDetails(
    id = id,
    title = title,
    user = user.toUser(),
    coverUri = coverUri,
    tracks = tracks.map { track -> track.toTrack() },
    createdDate = createdDate,
    playsCount = playsCount
)