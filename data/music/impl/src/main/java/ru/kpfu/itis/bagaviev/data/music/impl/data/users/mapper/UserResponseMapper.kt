package ru.kpfu.itis.bagaviev.data.music.impl.data.users.mapper

import ru.kpfu.itis.bagaviev.data.music.api.data.users.entities.UserDataEntity
import ru.kpfu.itis.bagaviev.data.music.api.data.users.entities.UserDetailsDataEntity
import ru.kpfu.itis.bagaviev.data.music.impl.data.playlists.mapper.toPlaylistDataEntity
import ru.kpfu.itis.bagaviev.data.music.impl.data.tracks.mapper.toTrackDataEntity
import ru.kpfu.itis.bagaviev.data.music.impl.data.users.pojo.responses.UserDetailsResponseEntity
import ru.kpfu.itis.bagaviev.data.music.impl.data.users.pojo.responses.UserResponse
import java.net.URI

fun UserResponse.toUserDataEntity(): UserDataEntity =
    UserDataEntity(id = id, login = login)

fun UserDetailsResponseEntity.toUserDetailsDataEntity(): UserDetailsDataEntity =
    UserDetailsDataEntity(
        id = id,
        login = login,
        avatarUri = URI.create(avatarUri),
        tracks = tracks.map { track -> track.toTrackDataEntity() },
        playlists = playlists.map { playlist -> playlist.toPlaylistDataEntity() }
    )
