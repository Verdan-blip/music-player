package ru.kpfu.itis.bagaviev.api.domain.tracks.repository

import ru.kpfu.itis.bagaviev.api.domain.tracks.entites.responses.TrackDetailsResponse
import ru.kpfu.itis.bagaviev.api.domain.tracks.entites.responses.TrackResponse

interface TrackRepository {

    suspend fun getCharts(
        limit: Int = 10,
        offset: Int = 0
    ): List<TrackResponse>

    suspend fun getById(trackId: Long): TrackDetailsResponse

    suspend fun getAllByKeywords(
        keywords: List<String>,
        limit: Int = 10,
        offset: Int = 0
    ): List<TrackResponse>
}