package ru.kpfu.itis.bagaviev.data.music.impl.data.network.user.repository

import ru.kpfu.itis.bagaviev.data.music.api.data.network.user.entity.UserDetailsDataEntity
import ru.kpfu.itis.bagaviev.data.music.api.data.network.user.entity.UserProfileDataEntity
import ru.kpfu.itis.bagaviev.data.music.api.data.network.user.repository.UserDataRepository
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.user.mapper.toUserDetailsDataEntity
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.user.mapper.toUserProfileDataEntity
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.user.service.UserApiService
import javax.inject.Inject

class UserDataRepositoryImpl @Inject constructor(
    private val userService: UserApiService
) : UserDataRepository {

    override suspend fun getUserById(userId: Long): UserDetailsDataEntity? =
        userService.getUserById(userId)
            ?.toUserDetailsDataEntity()

    override suspend fun getCurrentUserProfile(): UserProfileDataEntity =
        userService.getMyUserProfile()
            .toUserProfileDataEntity()
}