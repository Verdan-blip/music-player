package ru.kpfu.itis.bagaviev.features.feed.mapper

import ru.kpfu.itis.bagaviev.data.music.api.data.network.playlist.entity.PlaylistDataEntity
import ru.kpfu.itis.bagaviev.data.music.api.data.network.playlist.entity.PlaylistDetailsDataEntity
import ru.kpfu.itis.bagaviev.feed.api.domain.playlist.entity.Playlist
import ru.kpfu.itis.bagaviev.feed.api.domain.playlist.entity.PlaylistDetails

fun PlaylistDataEntity.toPlaylist(): Playlist = Playlist(
    id = id,
    title = title,
    coverUri = coverUri.toString(),
    author = user.toUser(),
    tracks = tracks.map { track -> track.toTrack() }
)

fun PlaylistDetailsDataEntity.toPlaylistDetails(): PlaylistDetails = PlaylistDetails(
    id = id,
    title = title,
    author = user.toUser(),
    coverUri = coverUri,
    tracks = tracks.map { track -> track.toTrack() },
    createdDate = createdDate,
    playsCount = playsCount
)