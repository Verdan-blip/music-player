package ru.kpfu.itis.bagaviev.feed.impl.presentation.view.recyclerview.mapper

import ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.author.AuthorFeedModel
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.playlist.PlaylistModel
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.track.TrackModel
import ru.kpfu.itis.bagaviev.theme.recyclerview.model.AuthorRvModel
import ru.kpfu.itis.bagaviev.theme.recyclerview.model.PlaylistRvModel
import ru.kpfu.itis.bagaviev.theme.recyclerview.model.TrackRvModel

fun AuthorFeedModel.toAuthorRvModel(): AuthorRvModel =
    AuthorRvModel(
        id = id,
        login = login,
        avatarUri = avatarUri
    )

fun TrackModel.toTrackRvModel(): TrackRvModel =
    TrackRvModel(
        id = id,
        title = title,
        smallCoverUri = smallCoverUri,
        authorNames = authorNames
    )

fun PlaylistModel.toPlaylistRvModel(): PlaylistRvModel =
    PlaylistRvModel(
        id = id,
        title = title,
        coverUri = coverUri
    )