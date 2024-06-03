package ru.kpfu.itis.bagaviev.feature.profile.domain.usecase

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import ru.kpfu.itis.bagaviev.common.di.modules.IODispatcher
import ru.kpfu.itis.bagaviev.feature.profile.domain.repository.FeatureProfileAuthRepository
import javax.inject.Inject

class CheckAuthenticationUseCase @Inject constructor(
    private val featureProfileAuthRepository: FeatureProfileAuthRepository,
    @IODispatcher private val coroutineDispatcher: CoroutineDispatcher
) {

    suspend operator fun invoke(): Result<Boolean> =
        runCatching {
            withContext(coroutineDispatcher) {
                featureProfileAuthRepository.isAuthenticated()
            }
        }
}