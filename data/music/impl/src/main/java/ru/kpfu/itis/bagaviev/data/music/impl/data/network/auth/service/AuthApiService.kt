package ru.kpfu.itis.bagaviev.data.music.impl.data.network.auth.service

import retrofit2.http.Body
import retrofit2.http.POST
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.auth.pojo.requests.LoginRequest
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.auth.pojo.requests.RefreshRequest
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.auth.pojo.requests.RegisterRequest
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.auth.pojo.responses.TokenResponse

interface AuthApiService {

    @POST("/api/v1/auth/signin")
    suspend fun signIn(@Body loginRequest: LoginRequest): TokenResponse

    @POST("/api/v1/auth/signup")
    suspend fun signUp(@Body registerRequest: RegisterRequest): TokenResponse
}