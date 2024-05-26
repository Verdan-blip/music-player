package ru.kpfu.itis.bagaviev.features.search

import ru.kpfu.itis.bagaviev.data.music.api.data.network.track.repository.TrackDataRepository
import ru.kpfu.itis.bagaviev.feature.search.api.domain.track.entity.TrackDetails
import ru.kpfu.itis.bagaviev.feature.search.api.domain.track.repository.FeatureSearchTrackRepository
import ru.kpfu.itis.bagaviev.features.search.mapper.toTrackDetails
import javax.inject.Inject

class AdapterFeatureSearchTrackRepository @Inject constructor(
    private val trackDataRepository: TrackDataRepository
) : FeatureSearchTrackRepository {

    override suspend fun getById(trackId: Long): TrackDetails? =
        trackDataRepository.getTrackById(trackId)
            ?.toTrackDetails()
}