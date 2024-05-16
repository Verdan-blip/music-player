package ru.kpfu.itis.bagaviev.feed.impl.presentation.entities.users.mappers

import androidx.core.net.toUri
import ru.kpfu.itis.bagaviev.feed.api.domain.user.User
import ru.kpfu.itis.bagaviev.feed.api.domain.user.UserDetails
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entities.playlists.mappers.toPlaylist
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entities.playlists.mappers.toPlaylistModel
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entities.tracks.mappers.toTrack
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entities.tracks.mappers.toTrackModel
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entities.users.UserDetailsModel
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entities.users.UserModel

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