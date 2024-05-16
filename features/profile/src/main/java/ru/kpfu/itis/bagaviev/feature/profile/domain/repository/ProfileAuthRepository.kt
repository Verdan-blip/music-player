package ru.kpfu.itis.bagaviev.feature.profile.domain.repository

interface ProfileAuthRepository {

    suspend fun isAuthenticated(): Boolean
}