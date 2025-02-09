package ru.kpfu.itis.bagaviev.feature.profile.domain.usecase

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import ru.kpfu.itis.bagaviev.common.di.modules.IODispatcher
import ru.kpfu.itis.bagaviev.feature.profile.domain.entity.user.UserProfile
import ru.kpfu.itis.bagaviev.feature.profile.domain.repository.FeatureProfileUserRepository
import javax.inject.Inject

class GetCurrentUserUseCase @Inject constructor(
    private val featureProfileUserRepository: FeatureProfileUserRepository,
    @IODispatcher private val coroutineDispatcher: CoroutineDispatcher
) {

    suspend operator fun invoke(): Result<UserProfile> =
        runCatching {
            withContext(coroutineDispatcher) {
                featureProfileUserRepository.getProfile()
            }
        }
}

