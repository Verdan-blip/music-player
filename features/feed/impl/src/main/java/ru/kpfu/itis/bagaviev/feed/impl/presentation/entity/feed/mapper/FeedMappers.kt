package ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.feed.mapper

import ru.kpfu.itis.bagaviev.feed.api.domain.feed.entity.Feed
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.feed.FeedModel
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.playlist.mapper.toPlaylistModel
import ru.kpfu.itis.bagaviev.feed.impl.presentation.entity.track.mapper.toTrackModel

fun Feed.toFeedModel(): FeedModel =
    FeedModel(
        chartTracks = chartTracks.map { track -> track.toTrackModel() },
        popularPlaylists = popularPlaylists.map { playlist -> playlist.toPlaylistModel() }
    )