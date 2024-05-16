package ru.kpfu.itis.bagaviev.feature.profile.presentation.entity.playlist.mapper

import ru.kpfu.itis.bagaviev.common.util.extensions.toUri
import ru.kpfu.itis.bagaviev.feature.profile.domain.entity.playlist.MyPlaylist
import ru.kpfu.itis.bagaviev.feature.profile.presentation.entity.track.mapper.toMyTrackModel
import ru.kpfu.itis.bagaviev.feature.profile.presentation.entity.user.mapper.toMyUserModel
import ru.kpfu.itis.bagaviev.feature.profile.presentation.entity.playlist.MyPlaylistModel

fun MyPlaylist.toMyPlaylistModel(): MyPlaylistModel =
    MyPlaylistModel(
        id = id,
        title = title,
        coverUri = coverUri.toUri(),
        user = user.toMyUserModel(),
        tracks = myTracks.map { track -> track.toMyTrackModel() }
    )