package ru.kpfu.itis.bagaviev.data.tracks.repository

import ru.kpfu.itis.bagaviev.data.tracks.entities.responses.TrackDetailsResponse
import ru.kpfu.itis.bagaviev.data.tracks.entities.responses.TrackResponse
import ru.kpfu.itis.bagaviev.data.tracks.service.TrackApiService

class TrackDataRepository(
    private val trackApiService: TrackApiService
) {

    fun getCharts(
        limit: Int = 10,
        offset: Int = 0
    ): List<TrackResponse> =
        trackApiService.getCharts(limit, offset)

    fun getById(trackId: Long): TrackDetailsResponse =
        trackApiService.getById(trackId)

    fun getAllByKeywords(
        keywords: List<String>,
        limit: Int = 10,
        offset: Int = 0
    ): List<TrackResponse> =
        trackApiService.getAllByKeywords(keywords.joinToString(separator = "+"))
}