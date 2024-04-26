package ru.kpfu.itis.bagaviev.impl.presentation.entities.playlists.mappers

import ru.kpfu.itis.bagaviev.api.domain.playlists.entites.responses.PlaylistDetailsResponse
import ru.kpfu.itis.bagaviev.api.domain.playlists.entites.responses.PlaylistResponse
import ru.kpfu.itis.bagaviev.feed.domain.playlists.entites.responses.PlaylistDetailsResponseModel
import ru.kpfu.itis.bagaviev.feed.domain.playlists.entites.responses.PlaylistResponseModel
import ru.kpfu.itis.bagaviev.impl.presentation.entities.tracks.mappers.toTrackResponse
import ru.kpfu.itis.bagaviev.impl.presentation.entities.tracks.mappers.toTrackResponseModel
import ru.kpfu.itis.bagaviev.impl.presentation.entities.users.mappers.toUserResponse
import ru.kpfu.itis.bagaviev.impl.presentation.entities.users.mappers.toUserResponseModel
import ru.kpfu.itis.common.util.extensions.toURI
import ru.kpfu.itis.common.util.extensions.toUri

fun PlaylistResponse.toPlaylistResponseModel(): PlaylistResponseModel =
    PlaylistResponseModel(
        id = id,
        title = title,
        coverUri = coverUri.toUri(),
        user = user.toUserResponseModel(),
        tracks = tracks.map { track -> track.toTrackResponseModel() }
    )

fun PlaylistResponseModel.toPlaylistResponse(): PlaylistResponse =
    PlaylistResponse(
        id = id,
        title = title,
        coverUri = coverUri.toURI(),
        user = user.toUserResponse(),
        tracks = tracks.map { track -> track.toTrackResponse() }
    )

fun PlaylistDetailsResponse.toPlaylistDetailsResponseModel(): PlaylistDetailsResponseModel =
    PlaylistDetailsResponseModel(
        id = id,
        title = title,
        coverUri = coverUri.toUri(),
        tracks = tracks.map { track -> track.toTrackResponseModel() },
        createdTime = createdTime,
        playsCount = playsCount
    )

fun PlaylistDetailsResponseModel.toPlaylistDetailsResponse(): PlaylistDetailsResponse =
    PlaylistDetailsResponse(
        id = id,
        title = title,
        coverUri = coverUri.toURI(),
        tracks = tracks.map { track -> track.toTrackResponse() },
        createdTime = createdTime,
        playsCount = playsCount
    )