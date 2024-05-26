package ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.playlist.mapper

import ru.kpfu.itis.bagaviev.common.util.extensions.toUri
import ru.kpfu.itis.bagaviev.feed.api.domain.playlist.entity.Playlist
import ru.kpfu.itis.bagaviev.feed.api.domain.playlist.entity.PlaylistDetails
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.author.mapper.toAuthorModel
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.playlist.PlaylistDetailsModel
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.playlist.PlaylistModel
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.track.mapper.toTrackModel

fun Playlist.toPlaylistModel(): PlaylistModel =
    PlaylistModel(
        id = id,
        title = title,
        coverUri = coverUri
    )


fun PlaylistDetails.toPlaylistDetailsModel(): PlaylistDetailsModel =
    PlaylistDetailsModel(
        id = id,
        title = title,
        coverUri = coverUri.toUri(),
        tracks = tracks.map { track -> track.toTrackModel() },
        createdTime = createdDate,
        playsCount = playsCount,
        author = author.toAuthorModel()
    )
