package ru.kpfu.itis.bagaviev.data.music.api.data.network.track.repository

import ru.kpfu.itis.bagaviev.data.music.api.data.network.track.entity.TrackDetailsDataEntity

interface TracksDataRepository {

    suspend fun getTrackById(trackId: Long): TrackDetailsDataEntity?
}