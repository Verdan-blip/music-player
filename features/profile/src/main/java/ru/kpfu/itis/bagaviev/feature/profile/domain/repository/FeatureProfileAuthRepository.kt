package ru.kpfu.itis.bagaviev.feature.profile.domain.repository

interface FeatureProfileAuthRepository {

    suspend fun isAuthenticated(): Boolean
}