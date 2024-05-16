package ru.kpfu.itis.bagaviev.data.music.impl.data.network.user.mapper

import ru.kpfu.itis.bagaviev.common.util.extensions.toURI
import ru.kpfu.itis.bagaviev.data.music.api.data.network.user.entity.UserDataEntity
import ru.kpfu.itis.bagaviev.data.music.api.data.network.user.entity.UserDetailsDataEntity
import ru.kpfu.itis.bagaviev.data.music.api.data.network.user.entity.UserProfileDataEntity
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.playlist.mapper.toPlaylistDataEntity
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.track.mapper.toTrackDataEntity
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.user.pojo.responses.UserDetailsResponse
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.user.pojo.responses.UserProfileResponse
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.user.pojo.responses.UserResponse

fun UserResponse.toUserDataEntity(): UserDataEntity =
    UserDataEntity(
        id = id,
        login = login
    )

fun UserDetailsResponse.toUserDetailsDataEntity(): UserDetailsDataEntity =
    UserDetailsDataEntity(
        id = id,
        login = login,
        avatarUri = avatarUri?.toURI(),
        tracks = tracks.map { track -> track.toTrackDataEntity() },
        playlists = playlists.map { playlist -> playlist.toPlaylistDataEntity() }
    )

fun UserProfileResponse.toUserProfileDataEntity(): UserProfileDataEntity =
    UserProfileDataEntity(
        id = id,
        login = login,
        email = email,
        avatarUri = avatarUri?.toURI(),
        tracks = tracks.map { track -> track.toTrackDataEntity() },
        playlists = playlists.map { playlist -> playlist.toPlaylistDataEntity() }
    )