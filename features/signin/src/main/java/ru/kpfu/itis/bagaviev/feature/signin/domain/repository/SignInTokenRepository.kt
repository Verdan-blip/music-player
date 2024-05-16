package ru.kpfu.itis.bagaviev.feature.signin.domain.repository

interface SignInTokenRepository {

    suspend fun saveAccessToken(
        accessToken: String
    )

    suspend fun saveRefreshToken(
        refreshToken: String
    )
}