package ru.kpfu.itis.bagaviev.feed.api.domain.track.repository

import ru.kpfu.itis.bagaviev.feed.api.domain.track.entity.TrackDetails
import ru.kpfu.itis.bagaviev.feed.api.domain.track.entity.Track

interface TrackRepository {

    suspend fun getCharts(
        limit: Int = 10,
        offset: Int = 0
    ): List<Track>

    suspend fun getById(trackId: Long): TrackDetails?
}