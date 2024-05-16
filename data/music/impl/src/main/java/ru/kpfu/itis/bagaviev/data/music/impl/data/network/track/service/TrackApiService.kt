package ru.kpfu.itis.bagaviev.data.music.impl.data.network.track.service

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.track.pojo.responses.TrackDetailsResponse
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.track.pojo.responses.TrackResponse

interface TrackApiService {

    @GET("/v1/tracks/charts")
    suspend fun getPopularTracks(
        @Query("page") limit: Int = 0,
        @Query("count") offset: Int = 5
    ): List<TrackResponse>

    @GET("/v1/tracks/{id}")
    suspend fun getTrackById(
        @Path("id") trackId: Long
    ): TrackDetailsResponse?

    @GET("/v1/tracks")
    suspend fun getAllByKeywords(
        @Query("keys") keys: String
    ): List<TrackResponse>
}