package ru.kpfu.itis.bagaviev.data.music.impl.data.network.auth.service

import retrofit2.http.Body
import retrofit2.http.POST
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.auth.pojo.requests.RefreshRequest
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.auth.pojo.responses.TokenResponse

interface RefreshTokenApiService {

    @POST("/api/v1/auth/refresh")
    suspend fun refresh(@Body refreshRequest: RefreshRequest): TokenResponse
}