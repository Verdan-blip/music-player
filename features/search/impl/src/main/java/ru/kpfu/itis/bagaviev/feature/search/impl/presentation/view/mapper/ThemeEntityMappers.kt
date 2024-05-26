package ru.kpfu.itis.bagaviev.feature.search.impl.presentation.view.mapper

import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.entities.author.AuthorFeedModel
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.entities.playlist.PlaylistModel
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.entities.track.TrackModel
import ru.kpfu.itis.bagaviev.theme.recyclerview.model.AuthorRvModel
import ru.kpfu.itis.bagaviev.theme.recyclerview.model.PlaylistRvModel
import ru.kpfu.itis.bagaviev.theme.recyclerview.model.TrackRvModel

fun TrackModel.toTrackRvModel(): TrackRvModel =
    TrackRvModel(
        id = id,
        title = title,
        smallCoverUri = smallCoverUri,
        authorNames = authors.map { authorModel -> authorModel.login }
    )

fun PlaylistModel.toPlaylistRvModel(): PlaylistRvModel =
    PlaylistRvModel(
        id = id,
        title = title,
        coverUri = coverUri
    )

fun AuthorFeedModel.toAuthorRvModel(): AuthorRvModel =
    AuthorRvModel(
        id = id,
        login = login,
        avatarUri = avatarUri
    )