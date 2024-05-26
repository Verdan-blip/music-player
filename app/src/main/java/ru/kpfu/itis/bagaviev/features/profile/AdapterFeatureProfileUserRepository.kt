package ru.kpfu.itis.bagaviev.features.profile

import ru.kpfu.itis.bagaviev.data.music.api.data.network.user.repository.UserDataRepository
import ru.kpfu.itis.bagaviev.feature.profile.domain.entity.user.UserProfile
import ru.kpfu.itis.bagaviev.feature.profile.domain.repository.FeatureProfileUserRepository
import ru.kpfu.itis.bagaviev.features.profile.mapper.toUserProfile
import javax.inject.Inject

class AdapterFeatureProfileUserRepository @Inject constructor(
    private val userDataRepository: UserDataRepository
) : FeatureProfileUserRepository {

    override suspend fun getProfile(): UserProfile =
        userDataRepository.getCurrentUserProfile()
            .toUserProfile()
}