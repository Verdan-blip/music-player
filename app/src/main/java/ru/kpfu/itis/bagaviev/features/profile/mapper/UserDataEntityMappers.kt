package ru.kpfu.itis.bagaviev.features.profile.mapper

import ru.kpfu.itis.bagaviev.data.music.api.data.network.user.entity.UserDataEntity
import ru.kpfu.itis.bagaviev.data.music.api.data.network.user.entity.UserProfileDataEntity
import ru.kpfu.itis.bagaviev.feature.profile.domain.entity.user.User
import ru.kpfu.itis.bagaviev.feature.profile.domain.entity.user.UserProfile

fun UserDataEntity.toUser(): User = User(
    id = id,
    login = login
)

fun UserProfileDataEntity.toUserProfile(): UserProfile =
    UserProfile(
        id = id,
        login = login,
        email = email,
        avatarUri = avatarUri,
        myTracks = tracks.map { track -> track.toMyTrack() },
        myPlaylists = playlists.map { playlist -> playlist.toMyPlaylist() }
    )