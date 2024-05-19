package ru.kpfu.itis.bagaviev.data.music.impl.data.network.playlist.service

import retrofit2.http.GET
import retrofit2.http.Path
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.playlist.pojo.responses.PlaylistDetailsResponse

interface PlaylistApiService {

    @GET("/api/v1/playlists/{playlistId}")
    suspend fun getById(
        @Path("playlistId") playlistId: Long
    ): PlaylistDetailsResponse?
}