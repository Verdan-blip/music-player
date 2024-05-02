package ru.kpfu.itis.bagaviev.music.data.playlists.service

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.kpfu.itis.bagaviev.music.data.playlists.entities.responses.PlaylistDetailsResponseEntity
import ru.kpfu.itis.bagaviev.music.data.playlists.entities.responses.PlaylistResponseEntity

interface PlaylistApiService {

    @GET("/v1/playlists/{id}")
    suspend fun getById(
        @Path("id") trackId: Long
    ): PlaylistDetailsResponseEntity?

    @GET("/v1/playlists/popular")
    suspend fun getPopularPlaylists(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): List<PlaylistResponseEntity>

    @GET("/v1/playlists")
    suspend fun getAllByKeywords(
        @Query("keys") keys: String
    ): List<PlaylistResponseEntity>
}