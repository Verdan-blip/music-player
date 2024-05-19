package ru.kpfu.itis.bagaviev.data.music.impl.data.network.track.service

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.track.pojo.responses.TrackDetailsResponse
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.track.pojo.responses.TrackResponse

interface TrackApiService {

    @GET("/api/v1/tracks/{trackId}")
    suspend fun getTrackById(
        @Path("trackId") trackId: Long
    ): TrackDetailsResponse?
}