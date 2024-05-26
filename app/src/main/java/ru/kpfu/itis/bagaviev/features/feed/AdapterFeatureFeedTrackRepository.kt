package ru.kpfu.itis.bagaviev.features.feed

import ru.kpfu.itis.bagaviev.data.music.api.data.network.track.repository.TrackDataRepository
import ru.kpfu.itis.bagaviev.feed.api.domain.track.entity.TrackDetails
import ru.kpfu.itis.bagaviev.feed.api.domain.track.repository.FeatureFeedTrackRepository
import ru.kpfu.itis.bagaviev.features.feed.mapper.toTrackDetails
import javax.inject.Inject

class AdapterFeatureFeedTrackRepository @Inject constructor(
    private val trackDataRepository: TrackDataRepository
) : FeatureFeedTrackRepository {

    override suspend fun getById(trackId: Long): TrackDetails? =
        trackDataRepository.getTrackById(trackId)
            ?.toTrackDetails()
}