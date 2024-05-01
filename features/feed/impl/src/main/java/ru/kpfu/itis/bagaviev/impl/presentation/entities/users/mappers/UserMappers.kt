package ru.kpfu.itis.bagaviev.impl.presentation.entities.users.mappers

import androidx.core.net.toUri
import ru.kpfu.itis.bagaviev.api.domain.users.UserDetails
import ru.kpfu.itis.bagaviev.api.domain.users.User
import ru.kpfu.itis.bagaviev.impl.presentation.entities.users.UserDetailsModel
import ru.kpfu.itis.bagaviev.impl.presentation.entities.users.UserModel
import ru.kpfu.itis.bagaviev.impl.presentation.entities.playlists.mappers.toPlaylist
import ru.kpfu.itis.bagaviev.impl.presentation.entities.playlists.mappers.toPlaylistModel
import ru.kpfu.itis.bagaviev.impl.presentation.entities.tracks.mappers.toTrack
import ru.kpfu.itis.bagaviev.impl.presentation.entities.tracks.mappers.toTrackModel

fun User.toUserModel(): UserModel =
    UserModel(
        id = id,
        login = login
    )

fun UserModel.toUser(): User =
    User(
        id = id,
        login = login
    )

fun UserDetails.toUserDetailsModel(): UserDetailsModel =
    UserDetailsModel(
        id = id,
        login = login,
        avatarUri = avatarUri.toUri(),
        tracks = tracks.map { track -> track.toTrackModel() },
        playlists = playlists.map { playlist -> playlist.toPlaylistModel() }
    )

fun UserDetailsModel.toUserDetails(): UserDetails =
    UserDetails(
        id = id,
        login = login,
        avatarUri = avatarUri.toString(),
        tracks = tracks.map { track -> track.toTrack() },
        playlists = playlists.map { playlist -> playlist.toPlaylist() }
    )