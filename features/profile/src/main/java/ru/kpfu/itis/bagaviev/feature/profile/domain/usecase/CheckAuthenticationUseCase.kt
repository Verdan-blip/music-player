package ru.kpfu.itis.bagaviev.feature.profile.domain.usecase

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import ru.kpfu.itis.bagaviev.common.di.modules.IODispatcher
import ru.kpfu.itis.bagaviev.feature.profile.domain.repository.ProfileAuthRepository
import javax.inject.Inject

class CheckAuthenticationUseCase @Inject constructor(
    private val profileAuthRepository: ProfileAuthRepository,
    @IODispatcher private val coroutineDispatcher: CoroutineDispatcher
) {

    suspend operator fun invoke(): Boolean =
        withContext(coroutineDispatcher) {
            profileAuthRepository.isAuthenticated()
        }
}