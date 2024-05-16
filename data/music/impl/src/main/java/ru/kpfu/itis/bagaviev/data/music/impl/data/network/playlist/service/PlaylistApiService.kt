package ru.kpfu.itis.bagaviev.data.music.impl.data.network.playlist.service

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.playlist.pojo.responses.PlaylistDetailsResponse
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.playlist.pojo.responses.PlaylistResponse

interface PlaylistApiService {

    @GET("/v1/playlists/{id}")
    suspend fun getById(
        @Path("id") trackId: Long
    ): PlaylistDetailsResponse?

    @GET("/v1/playlists/popular")
    suspend fun getPopularPlaylists(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): List<PlaylistResponse>

    @GET("/v1/playlists")
    suspend fun getAllByKeywords(
        @Query("keys") keys: String
    ): List<PlaylistResponse>
}