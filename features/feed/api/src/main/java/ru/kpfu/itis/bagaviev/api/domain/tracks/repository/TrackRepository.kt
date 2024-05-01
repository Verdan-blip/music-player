package ru.kpfu.itis.bagaviev.api.domain.tracks.repository

import ru.kpfu.itis.bagaviev.api.domain.tracks.entites.TrackDetails
import ru.kpfu.itis.bagaviev.api.domain.tracks.entites.Track

interface TrackRepository {

    suspend fun getCharts(
        limit: Int = 10,
        offset: Int = 0
    ): List<Track>

    suspend fun getById(trackId: Long): TrackDetails?

    suspend fun getAllByKeywords(
        keywords: List<String>,
        limit: Int = 10,
        offset: Int = 0
    ): List<Track>
}