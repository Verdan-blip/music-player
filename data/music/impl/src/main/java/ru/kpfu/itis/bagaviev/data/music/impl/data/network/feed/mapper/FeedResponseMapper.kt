package ru.kpfu.itis.bagaviev.data.music.impl.data.network.feed.mapper

import ru.kpfu.itis.bagaviev.data.music.api.data.network.feed.entity.FeedDataEntity
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.feed.pojo.FeedResponse
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.playlist.mapper.toPlaylistDataEntity
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.track.mapper.toTrackDataEntity

fun FeedResponse.toFeedDataEntity(): FeedDataEntity =
    FeedDataEntity(
        chartTracks = chartTracks.map { track -> track.toTrackDataEntity() },
        popularPlaylists = popularPlaylists.map { playlist -> playlist.toPlaylistDataEntity() }
    )