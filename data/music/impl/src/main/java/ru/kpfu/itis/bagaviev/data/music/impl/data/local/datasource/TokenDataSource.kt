package ru.kpfu.itis.bagaviev.data.music.impl.data.local.datasource

interface TokenDataSource {

    fun getAccessToken(): String?

    fun getRefreshToken(): String?

    fun saveAccessToken(accessToken: String)

    fun saveRefreshToken(refreshToken: String)
}