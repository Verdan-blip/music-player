package ru.kpfu.itis.auth.token.repository

interface AuthTokenDataRepository {

    fun saveAccessToken(accessToken: String)

    fun getAccessToken(): String?

    fun saveRefreshToken(refreshToken: String)

    fun getRefreshToken(): String?
}