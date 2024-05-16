package ru.kpfu.itis.bagaviev.data.music.api.data.network.user.repository

import ru.kpfu.itis.bagaviev.data.music.api.data.network.user.entity.UserDetailsDataEntity
import ru.kpfu.itis.bagaviev.data.music.api.data.network.user.entity.UserProfileDataEntity

interface UserDataRepository {

    suspend fun getUserById(userId: Long): UserDetailsDataEntity?

    suspend fun getCurrentUserProfile(): UserProfileDataEntity
}