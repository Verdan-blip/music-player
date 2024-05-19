package ru.kpfu.itis.bagaviev.feed.impl.data.feed.mapper

import ru.kpfu.itis.bagaviev.data.music.api.data.network.feed.entity.FeedDataEntity
import ru.kpfu.itis.bagaviev.feed.api.domain.feed.entity.Feed
import ru.kpfu.itis.bagaviev.feed.impl.data.playlist.mapper.toPlaylist
import ru.kpfu.itis.bagaviev.feed.impl.data.track.mapper.toTrack

fun FeedDataEntity.toFeed(): Feed =
    Feed(
        chartTracks = chartTracks.map { track -> track.toTrack() },
        popularPlaylists = popularPlaylists.map { playlist -> playlist.toPlaylist() }
    )