package ru.kpfu.itis.bagaviev.data.music.impl.data.local.token.datasource

interface TokenDataSource {

    fun getAccessToken(): String?

    fun getRefreshToken(): String?

    fun getExpiration(): Long?

    fun saveAccessToken(accessToken: String)

    fun saveRefreshToken(refreshToken: String)

    fun saveExpiration(expiresAt: Long)
}