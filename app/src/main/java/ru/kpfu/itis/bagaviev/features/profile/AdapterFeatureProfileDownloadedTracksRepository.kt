package ru.kpfu.itis.bagaviev.features.profile

import ru.kpfu.itis.bagaviev.data.music.api.data.local.music.repository.DownloadedTrackDataRepository
import ru.kpfu.itis.bagaviev.feature.profile.domain.entity.track.DownloadedTrack
import ru.kpfu.itis.bagaviev.feature.profile.domain.repository.FeatureProfileDownloadedTrackRepository
import ru.kpfu.itis.bagaviev.features.profile.mapper.toDownloadedTrack
import javax.inject.Inject

class AdapterFeatureProfileDownloadedTracksRepository @Inject constructor(
    private val downloadedTrackDataRepository: DownloadedTrackDataRepository
) : FeatureProfileDownloadedTrackRepository {

    override suspend fun getAll(): List<DownloadedTrack> =
        downloadedTrackDataRepository.getAllCachedTracks().map {
            downloadedTrackDataEntity -> downloadedTrackDataEntity.toDownloadedTrack()
        }
}