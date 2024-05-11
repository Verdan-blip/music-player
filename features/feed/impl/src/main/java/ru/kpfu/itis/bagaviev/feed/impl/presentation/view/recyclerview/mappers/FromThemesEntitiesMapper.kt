package ru.kpfu.itis.bagaviev.feed.impl.presentation.view.recyclerview.mappers

import ru.kpfu.itis.bagaviev.feed.impl.presentation.entities.playlists.PlaylistModel
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entities.tracks.TrackModel
import ru.kpfu.itis.bagaviev.theme.recyclerview.model.PlaylistItem
import ru.kpfu.itis.bagaviev.theme.recyclerview.model.TrackItem

fun TrackModel.toTrackItem(): TrackItem =
    TrackItem(
        id = id,
        title = title,
        users = users.map { userModel -> userModel.login },
        smallCoverUri = smallCoverUri
    )

fun PlaylistModel.toPlaylistItem(): PlaylistItem =
    PlaylistItem(
        id = id,
        title = title,
        coverUri = coverUri,
        user = user.login,
        tracks = tracks.map { trackModel -> trackModel.toTrackItem() }
    )