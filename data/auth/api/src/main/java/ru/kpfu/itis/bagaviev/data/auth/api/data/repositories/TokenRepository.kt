package ru.kpfu.itis.bagaviev.data.auth.api.data.repositories

interface TokenRepository {

    fun getRefreshToken(): String?

    fun getAccessToken(): String?
}