package ru.kpfu.itis.bagaviev.feed.api.domain.track.repository

import ru.kpfu.itis.bagaviev.feed.api.domain.track.entity.TrackDetails
import ru.kpfu.itis.bagaviev.feed.api.domain.track.entity.Track

interface TrackRepository {

    suspend fun getById(trackId: Long): TrackDetails?
}