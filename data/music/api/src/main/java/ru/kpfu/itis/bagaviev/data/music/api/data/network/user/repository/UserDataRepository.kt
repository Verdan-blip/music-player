package ru.kpfu.itis.bagaviev.data.music.api.data.network.user.repository

import ru.kpfu.itis.bagaviev.data.music.api.data.network.user.entity.UserDataEntity
import ru.kpfu.itis.bagaviev.data.music.api.data.network.user.entity.UserDetailsDataEntity
import ru.kpfu.itis.bagaviev.data.music.api.data.network.user.entity.UserProfileDataEntity

interface UserDataRepository {

    suspend fun getUserById(userId: Long): UserDetailsDataEntity?

    suspend fun searchUsersByKeywords(keywords: List<String>): List<UserDataEntity>

    suspend fun getCurrentUserProfile(): UserProfileDataEntity
}