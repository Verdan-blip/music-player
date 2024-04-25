package ru.kpfu.itis.bagaviev.data.tracks.service

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.kpfu.itis.bagaviev.data.tracks.entities.responses.TrackDetailsResponse
import ru.kpfu.itis.bagaviev.data.tracks.entities.responses.TrackResponse

interface TrackApiService {

    @GET("/v1/tracks/charts")
    fun getCharts(
        @Query("limit") limit: Int = 10,
        @Query("offset") offset: Int = 0
    ): List<TrackResponse>

    @GET("/v1/tracks/{id}")
    fun getById(
        @Path("id") trackId: Long
    ): TrackDetailsResponse

    @GET("/v1/tracks")
    fun getAllByKeywords(
        @Query("keys") keys: String
    ): List<TrackResponse>
}