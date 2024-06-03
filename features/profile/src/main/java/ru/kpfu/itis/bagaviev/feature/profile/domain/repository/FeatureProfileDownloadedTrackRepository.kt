package ru.kpfu.itis.bagaviev.feature.profile.domain.repository

import ru.kpfu.itis.bagaviev.feature.profile.domain.entity.track.DownloadedTrack

interface FeatureProfileDownloadedTrackRepository {

    suspend fun getAll(): List<DownloadedTrack>
}