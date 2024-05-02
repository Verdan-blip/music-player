package ru.kpfu.itis.bagaviev.glue.feed

import ru.kpfu.itis.bagaviev.feed.api.domain.tracks.entites.TrackDetails
import ru.kpfu.itis.bagaviev.feed.api.domain.tracks.entites.Track
import ru.kpfu.itis.bagaviev.feed.api.domain.tracks.repository.TrackRepository
import ru.kpfu.itis.bagaviev.music.data.tracks.repository.TrackDataRepository
import ru.kpfu.itis.bagaviev.glue.feed.mappers.tracks.toTrackDetails
import ru.kpfu.itis.bagaviev.glue.feed.mappers.tracks.toTrack
import javax.inject.Inject

class AdapterTrackRepository @Inject constructor(
    private val trackDataRepository: TrackDataRepository
): TrackRepository {

    override suspend fun getCharts(limit: Int, offset: Int): List<Track> =
        trackDataRepository.getCharts(limit, offset).map {  trackResponse ->
            trackResponse.toTrack()
        }

    override suspend fun getById(trackId: Long): TrackDetails? =
        trackDataRepository.getById(trackId)?.toTrackDetails()

    override suspend fun getAllByKeywords(
        keywords: List<String>,
        limit: Int,
        offset: Int
    ): List<Track> =
        trackDataRepository.getAllByKeywords(keywords, limit, offset).map { trackResponse ->
            trackResponse.toTrack()
        }
}