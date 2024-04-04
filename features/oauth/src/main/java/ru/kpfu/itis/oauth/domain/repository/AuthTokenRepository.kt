package ru.kpfu.itis.oauth.domain.repository

interface AuthTokenRepository {

    suspend fun saveAccessToken(accessToken: String)

    suspend fun getAccessToken(): String?

}