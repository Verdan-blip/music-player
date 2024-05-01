package ru.kpfu.itis.bagaviev.glue.feed.mappers.playlists

import ru.kpfu.itis.bagaviev.api.domain.playlists.entites.Playlist
import ru.kpfu.itis.bagaviev.api.domain.playlists.entites.PlaylistDetails
import ru.kpfu.itis.bagaviev.data.playlists.entities.responses.PlaylistDetailsResponseEntity
import ru.kpfu.itis.bagaviev.data.playlists.entities.responses.PlaylistResponseEntity
import ru.kpfu.itis.bagaviev.glue.feed.mappers.tracks.toTrack
import ru.kpfu.itis.bagaviev.glue.feed.mappers.tracks.toTrackResponseEntity
import ru.kpfu.itis.bagaviev.glue.feed.mappers.users.toUserResponse
import ru.kpfu.itis.bagaviev.glue.feed.mappers.users.toUserResponseEntity
import ru.kpfu.itis.common.util.extensions.toURI
import java.sql.Timestamp
import java.util.Calendar
import java.util.Date

fun Playlist.toPlaylistResponseEntity(): PlaylistResponseEntity =
    PlaylistResponseEntity(
        id = id,
        title = title,
        coverUri = coverUri.toString(),
        user = user.toUserResponseEntity(),
        tracks = tracks.map { track -> track.toTrackResponseEntity() }
    )

fun PlaylistResponseEntity.toPlaylistResponse(): Playlist =
    Playlist(
        id = id,
        title = title,
        coverUri = coverUri.toURI(),
        user = user.toUserResponse(),
        tracks = tracks.map { track -> track.toTrack() }
    )

fun PlaylistDetails.toPlaylistDetailsResponseEntity(): PlaylistDetailsResponseEntity =
    PlaylistDetailsResponseEntity(
        id = id,
        title = title,
        coverUri = coverUri.toString(),
        tracks = tracks.map { track -> track.toTrackResponseEntity() },
        createdDate = createdDate.toString(),
        user = user.toUserResponseEntity(),
        playsCount = playsCount
    )

fun PlaylistDetailsResponseEntity.toPlaylistDetailsResponse(): PlaylistDetails =
    PlaylistDetails(
        id = id,
        title = title,
        coverUri = coverUri.toURI(),
        tracks = tracks.map { track -> track.toTrack() },
        createdDate = Date(0L),
        user = user.toUserResponse(),
        playsCount = playsCount
    )