package ru.kpfu.itis.bagaviev.glue.feed.mappers.users

import ru.kpfu.itis.bagaviev.api.domain.users.UserDetails
import ru.kpfu.itis.bagaviev.api.domain.users.User
import ru.kpfu.itis.bagaviev.data.users.entites.responses.UserDetailsResponseEntity
import ru.kpfu.itis.bagaviev.data.users.entites.responses.UserResponseEntity
import ru.kpfu.itis.bagaviev.glue.feed.mappers.playlists.toPlaylistResponse
import ru.kpfu.itis.bagaviev.glue.feed.mappers.playlists.toPlaylistResponseEntity
import ru.kpfu.itis.bagaviev.glue.feed.mappers.tracks.toTrack
import ru.kpfu.itis.bagaviev.glue.feed.mappers.tracks.toTrackResponseEntity

fun User.toUserResponseEntity(): UserResponseEntity =
    UserResponseEntity(
        id = id,
        login = login
    )

fun UserResponseEntity.toUserResponse(): User =
    User(
        id = id,
        login = login
    )

fun UserDetails.toUserDetailsResponseEntity(): UserDetailsResponseEntity =
    UserDetailsResponseEntity(
        id = id,
        login = login,
        avatarUri = avatarUri,
        tracks = tracks.map { track -> track.toTrackResponseEntity() },
        playlists = playlists.map { playlist -> playlist.toPlaylistResponseEntity() }
    )

fun UserDetailsResponseEntity.toUserDetailsResponse(): UserDetails =
    UserDetails(
        id = id,
        login = login,
        avatarUri = avatarUri,
        tracks = tracks.map { track -> track.toTrack() },
        playlists = playlists.map { playlist -> playlist.toPlaylistResponse() }
    )