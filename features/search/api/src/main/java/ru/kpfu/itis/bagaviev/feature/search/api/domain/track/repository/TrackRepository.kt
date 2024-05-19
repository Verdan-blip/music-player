package ru.kpfu.itis.bagaviev.feature.search.api.domain.track.repository

import ru.kpfu.itis.bagaviev.feature.search.api.domain.track.entity.TrackDetails
import ru.kpfu.itis.bagaviev.feature.search.api.domain.track.entity.Track

interface TrackRepository {

    suspend fun getById(trackId: Long): TrackDetails?
}