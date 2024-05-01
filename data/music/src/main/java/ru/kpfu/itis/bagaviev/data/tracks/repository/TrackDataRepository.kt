package ru.kpfu.itis.bagaviev.data.tracks.repository

import ru.kpfu.itis.bagaviev.data.tracks.entities.responses.TrackDetailsResponseEntity
import ru.kpfu.itis.bagaviev.data.tracks.entities.responses.TrackResponseEntity
import ru.kpfu.itis.bagaviev.data.tracks.service.TrackApiService
import javax.inject.Inject

class TrackDataRepository @Inject constructor(
    private val trackApiService: TrackApiService
) {

    suspend fun getCharts(
        limit: Int = 10,
        offset: Int = 0
    ): List<TrackResponseEntity> =
        trackApiService.getCharts(limit, offset)

    suspend fun getById(trackId: Long): TrackDetailsResponseEntity? =
        trackApiService.getById(trackId)

    suspend fun getAllByKeywords(
        keywords: List<String>,
        limit: Int = 10,
        offset: Int = 0
    ): List<TrackResponseEntity> =
        trackApiService.getAllByKeywords(keywords.joinToString(separator = "+"))
}