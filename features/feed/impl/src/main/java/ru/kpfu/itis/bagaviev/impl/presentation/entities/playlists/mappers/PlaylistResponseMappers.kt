package ru.kpfu.itis.bagaviev.impl.presentation.entities.playlists.mappers

import ru.kpfu.itis.bagaviev.api.domain.playlists.entites.PlaylistDetails
import ru.kpfu.itis.bagaviev.api.domain.playlists.entites.Playlist
import ru.kpfu.itis.bagaviev.impl.presentation.entities.playlists.PlaylistDetailsModel
import ru.kpfu.itis.bagaviev.impl.presentation.entities.playlists.PlaylistModel
import ru.kpfu.itis.bagaviev.impl.presentation.entities.tracks.mappers.toTrack
import ru.kpfu.itis.bagaviev.impl.presentation.entities.tracks.mappers.toTrackModel
import ru.kpfu.itis.bagaviev.impl.presentation.entities.users.mappers.toUser
import ru.kpfu.itis.bagaviev.impl.presentation.entities.users.mappers.toUserModel
import ru.kpfu.itis.common.util.extensions.toURI
import ru.kpfu.itis.common.util.extensions.toUri

fun Playlist.toPlaylistModel(): PlaylistModel =
    PlaylistModel(
        id = id,
        title = title,
        coverUri = coverUri.toUri(),
        user = user.toUserModel(),
        tracks = tracks.map { track -> track.toTrackModel() }
    )

fun PlaylistModel.toPlaylist(): Playlist =
    Playlist(
        id = id,
        title = title,
        coverUri = coverUri.toURI(),
        user = user.toUser(),
        tracks = tracks.map { track -> track.toTrack() }
    )

fun PlaylistDetails.toPlaylistDetailsModel(): PlaylistDetailsModel =
    PlaylistDetailsModel(
        id = id,
        title = title,
        coverUri = coverUri.toUri(),
        tracks = tracks.map { track -> track.toTrackModel() },
        createdTime = createdDate,
        playsCount = playsCount,
        user = user.toUserModel()
    )

fun PlaylistDetailsModel.toPlaylistDetails(): PlaylistDetails =
    PlaylistDetails(
        id = id,
        title = title,
        coverUri = coverUri.toURI(),
        tracks = tracks.map { track -> track.toTrack() },
        createdDate = createdTime,
        playsCount = playsCount,
        user = user.toUser()
    )