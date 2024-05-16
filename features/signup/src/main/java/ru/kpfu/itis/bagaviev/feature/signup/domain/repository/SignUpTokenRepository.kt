package ru.kpfu.itis.bagaviev.feature.signup.domain.repository

interface SignUpTokenRepository {

    suspend fun saveAccessToken(
        accessToken: String
    )

    suspend fun saveRefreshToken(
        refreshToken: String
    )
}