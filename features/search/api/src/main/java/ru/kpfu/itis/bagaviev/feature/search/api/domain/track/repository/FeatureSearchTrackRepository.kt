package ru.kpfu.itis.bagaviev.feature.search.api.domain.track.repository

import ru.kpfu.itis.bagaviev.feature.search.api.domain.track.entity.TrackDetails

interface FeatureSearchTrackRepository {

    suspend fun getById(trackId: Long): TrackDetails?
}