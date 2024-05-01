package ru.kpfu.itis.bagaviev.data.tracks.service

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.kpfu.itis.bagaviev.data.tracks.entities.responses.TrackDetailsResponseEntity
import ru.kpfu.itis.bagaviev.data.tracks.entities.responses.TrackResponseEntity

interface TrackApiService {

    @GET("/v1/tracks/charts")
    suspend fun getCharts(
        @Query("limit") limit: Int = 10,
        @Query("offset") offset: Int = 0
    ): List<TrackResponseEntity>

    @GET("/v1/tracks/{id}")
    suspend fun getById(
        @Path("id") trackId: Long
    ): TrackDetailsResponseEntity?

    @GET("/v1/tracks")
    suspend fun getAllByKeywords(
        @Query("keys") keys: String
    ): List<TrackResponseEntity>
}