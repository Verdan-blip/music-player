package ru.kpfu.itis.bagaviev.data.music.api.data.local.token.repository

interface TokenDataRepository {

    fun getAccessToken(): String?

    fun getRefreshToken(): String?

    fun getExpiration(): Long?

    fun saveAccessToken(accessToken: String)

    fun saveRefreshToken(refreshToken: String)

    fun saveExpiration(expiresAt: Long)
}