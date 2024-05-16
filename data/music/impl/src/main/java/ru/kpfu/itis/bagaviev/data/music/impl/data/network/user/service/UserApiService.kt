package ru.kpfu.itis.bagaviev.data.music.impl.data.network.user.service

import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.user.pojo.responses.UserDetailsResponse
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.user.pojo.responses.UserProfileResponse

interface UserApiService {

    @GET("/api/v1/users/{id}")
    suspend fun getUserById(@Path("id") userId: Long): UserDetailsResponse?

    @GET("/api/v1/profile/me")
    suspend fun getMyUserProfile(): UserProfileResponse
}