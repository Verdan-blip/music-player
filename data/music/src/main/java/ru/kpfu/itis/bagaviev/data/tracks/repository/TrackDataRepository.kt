package ru.kpfu.itis.bagaviev.data.tracks.repository

import ru.kpfu.itis.bagaviev.data.tracks.entities.responses.TrackDetailsResponseEntity
import ru.kpfu.itis.bagaviev.data.tracks.entities.responses.TrackResponseEntity
import ru.kpfu.itis.bagaviev.data.tracks.service.TrackApiService

class TrackDataRepository(
    private val trackApiService: TrackApiService
) {

    fun getCharts(
        limit: Int = 10,
        offset: Int = 0
    ): List<TrackResponseEntity> =
        trackApiService.getCharts(limit, offset)

    fun getById(trackId: Long): TrackDetailsResponseEntity =
        trackApiService.getById(trackId)

    fun getAllByKeywords(
        keywords: List<String>,
        limit: Int = 10,
        offset: Int = 0
    ): List<TrackResponseEntity> =
        trackApiService.getAllByKeywords(keywords.joinToString(separator = "+"))
}