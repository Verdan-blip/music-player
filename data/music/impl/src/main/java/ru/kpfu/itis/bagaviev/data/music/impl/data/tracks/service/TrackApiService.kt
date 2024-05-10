package ru.kpfu.itis.bagaviev.data.music.impl.data.tracks.service

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.kpfu.itis.bagaviev.data.music.impl.data.tracks.pojo.responses.TrackDetailsResponse
import ru.kpfu.itis.bagaviev.data.music.impl.data.tracks.pojo.responses.TrackResponse

interface TrackApiService {

    @GET("/v1/tracks/charts")
    suspend fun getPopularTracks(
        @Query("limit") limit: Int = 10,
        @Query("offset") offset: Int = 0
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