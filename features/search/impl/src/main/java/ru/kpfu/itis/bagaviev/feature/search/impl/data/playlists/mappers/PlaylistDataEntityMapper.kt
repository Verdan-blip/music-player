package ru.kpfu.itis.bagaviev.feature.search.impl.data.playlists.mappers

import ru.kpfu.itis.bagaviev.data.music.api.data.network.playlist.entities.PlaylistDataEntity
import ru.kpfu.itis.bagaviev.data.music.api.data.network.playlist.entities.PlaylistDetailsDataEntity
import ru.kpfu.itis.bagaviev.feature.search.api.domain.playlists.entites.Playlist
import ru.kpfu.itis.bagaviev.feature.search.api.domain.playlists.entites.PlaylistDetails
import ru.kpfu.itis.bagaviev.feature.search.impl.data.users.mappers.toUser
import ru.kpfu.itis.bagaviev.feature.search.impl.data.tracks.mappers.toTrack

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