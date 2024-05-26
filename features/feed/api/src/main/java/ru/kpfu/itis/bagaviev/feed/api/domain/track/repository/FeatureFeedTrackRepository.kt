package ru.kpfu.itis.bagaviev.feed.api.domain.track.repository

import ru.kpfu.itis.bagaviev.feed.api.domain.track.entity.TrackDetails

interface FeatureFeedTrackRepository {

    suspend fun getById(trackId: Long): TrackDetails?
}