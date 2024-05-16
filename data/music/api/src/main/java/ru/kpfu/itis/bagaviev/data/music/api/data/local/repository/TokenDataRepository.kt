package ru.kpfu.itis.bagaviev.data.music.api.data.local.repository

interface TokenDataRepository {

    suspend fun saveAccessToken(accessToken: String)

    suspend fun saveRefreshToken(refreshToken: String)

    suspend fun getAccessToken(): String?

    suspend fun getRefreshToken(): String?
}