package ru.kpfu.itis.bagaviev.feed.impl.data.playlists.mappers

import ru.kpfu.itis.bagaviev.data.music.api.data.playlists.entities.PlaylistDataEntity
import ru.kpfu.itis.bagaviev.data.music.api.data.playlists.entities.PlaylistDetailsDataEntity
import ru.kpfu.itis.bagaviev.feed.api.domain.playlists.entites.Playlist
import ru.kpfu.itis.bagaviev.feed.api.domain.playlists.entites.PlaylistDetails
import ru.kpfu.itis.bagaviev.feed.impl.data.tracks.mappers.toTrack
import ru.kpfu.itis.bagaviev.feed.impl.data.users.mappers.toUser

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