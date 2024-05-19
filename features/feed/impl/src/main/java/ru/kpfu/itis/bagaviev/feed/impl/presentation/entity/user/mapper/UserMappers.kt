package ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.user.mapper

import androidx.core.net.toUri
import ru.kpfu.itis.bagaviev.feed.api.domain.user.User
import ru.kpfu.itis.bagaviev.feed.api.domain.user.UserDetails
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.playlist.mapper.toPlaylist
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.playlist.mapper.toPlaylistModel
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.track.mapper.toTrack
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.track.mapper.toTrackModel
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.user.UserDetailsModel
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.user.UserModel

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