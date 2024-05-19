package ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.playlist.mapper

import ru.kpfu.itis.bagaviev.feed.api.domain.playlist.entity.Playlist
import ru.kpfu.itis.bagaviev.feed.api.domain.playlist.entity.PlaylistDetails
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.playlist.PlaylistDetailsModel
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.playlist.PlaylistModel
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.track.mapper.toTrack
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.track.mapper.toTrackModel
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.user.mapper.toUser
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.user.mapper.toUserModel
import ru.kpfu.itis.bagaviev.common.util.extensions.toURI
import ru.kpfu.itis.bagaviev.common.util.extensions.toUri

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