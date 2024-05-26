package ru.kpfu.itis.bagaviev.features.upload

import ru.kpfu.itis.bagaviev.data.music.api.data.network.user.repository.UserDataRepository
import ru.kpfu.itis.bagaviev.feature.upload.domain.entity.User
import ru.kpfu.itis.bagaviev.feature.upload.domain.repository.FeatureSearchUserRepository
import ru.kpfu.itis.bagaviev.features.upload.mapper.toUser
import javax.inject.Inject

class AdapterFeatureSearchUserRepository @Inject constructor(
    private val userDataRepository: UserDataRepository
) : FeatureSearchUserRepository {

    override suspend fun searchUsersByKeywords(keywords: List<String>): List<User> =
        userDataRepository.searchUsersByKeywords(keywords).map {
            userDataEntity -> userDataEntity.toUser()
        }
}