package ru.kpfu.itis.bagaviev.impl.presentation.entities.users.mappers

import androidx.core.net.toUri
import ru.kpfu.itis.bagaviev.api.domain.users.response.UserDetailsResponse
import ru.kpfu.itis.bagaviev.api.domain.users.response.UserResponse
import ru.kpfu.itis.bagaviev.feed.domain.users.response.UserDetailsResponseModel
import ru.kpfu.itis.bagaviev.feed.domain.users.response.UserResponseModel
import ru.kpfu.itis.bagaviev.impl.presentation.entities.playlists.mappers.toPlaylistResponse
import ru.kpfu.itis.bagaviev.impl.presentation.entities.playlists.mappers.toPlaylistResponseModel
import ru.kpfu.itis.bagaviev.impl.presentation.entities.tracks.mappers.toTrackResponse
import ru.kpfu.itis.bagaviev.impl.presentation.entities.tracks.mappers.toTrackResponseModel

fun UserResponse.toUserResponseModel(): UserResponseModel =
    UserResponseModel(
        id = id,
        login = login
    )

fun UserResponseModel.toUserResponse(): UserResponse =
    UserResponse(
        id = id,
        login = login
    )

fun UserDetailsResponse.toUserDetailsResponseModel(): UserDetailsResponseModel =
    UserDetailsResponseModel(
        id = id,
        login = login,
        avatarUri = avatarUri.toUri(),
        tracks = tracks.map { track -> track.toTrackResponseModel() },
        playlists = playlists.map { playlist -> playlist.toPlaylistResponseModel() }
    )

fun UserDetailsResponseModel.toUserDetailsResponse(): UserDetailsResponse =
    UserDetailsResponse(
        id = id,
        login = login,
        avatarUri = avatarUri.toString(),
        tracks = tracks.map { track -> track.toTrackResponse() },
        playlists = playlists.map { playlist -> playlist.toPlaylistResponse() }
    )