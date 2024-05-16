package ru.kpfu.itis.bagaviev.feature.profile.domain.repository

import ru.kpfu.itis.bagaviev.feature.profile.domain.entity.user.UserProfile

interface UserRepository {

    suspend fun getProfile(): UserProfile
}