package ru.kpfu.itis.bagaviev.data.playlists.service

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.kpfu.itis.bagaviev.data.playlists.entities.responses.PlaylistDetailsResponseEntity
import ru.kpfu.itis.bagaviev.data.playlists.entities.responses.PlaylistResponseEntity

interface PlaylistApiService {

    @GET("/v1/tracks/{id}")
    fun getById(
        @Path("id") trackId: Long
    ): PlaylistDetailsResponseEntity

    @GET("/v1/tracks")
    fun getAllByKeywords(
        @Query("keys") keys: String
    ): List<PlaylistResponseEntity>
}