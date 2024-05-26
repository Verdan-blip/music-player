package ru.kpfu.itis.bagaviev.feature.search.impl.presentation.entities.playlist.mappers

import ru.kpfu.itis.bagaviev.feature.search.api.domain.playlists.entity.Playlist
import ru.kpfu.itis.bagaviev.feature.search.api.domain.playlists.entity.PlaylistDetails
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.entities.author.mappers.toAuthorModel
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.entities.playlist.PlaylistDetailsModel
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.entities.playlist.PlaylistModel
import ru.kpfu.itis.bagaviev.feature.search.impl.presentation.entities.track.mappers.toTrackModel

fun Playlist.toPlaylistModel(): PlaylistModel =
    PlaylistModel(
        id = id,
        title = title,
        coverUri = coverUri,
    )

fun PlaylistDetails.toPlaylistDetailsModel(): PlaylistDetailsModel =
    PlaylistDetailsModel(
        id = id,
        title = title,
        coverUri = coverUri,
        tracks = tracks.map { track -> track.toTrackModel() },
        createdTime = createdDate,
        playsCount = playsCount,
        user = author.toAuthorModel()
    )