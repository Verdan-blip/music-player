package ru.kpfu.itis.bagaviev.feature.signup.domain.usecases

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import ru.kpfu.itis.bagaviev.common.di.modules.IODispatcher
import ru.kpfu.itis.bagaviev.feature.signup.domain.repository.SignUpTokenRepository
import javax.inject.Inject

class SaveAccessTokenUseCase @Inject constructor(
    private val signUpTokenRepository: SignUpTokenRepository,
    @IODispatcher private val coroutineDispatcher: CoroutineDispatcher
) {

    suspend operator fun invoke(accessToken: String) {
        withContext(coroutineDispatcher) {
            signUpTokenRepository.saveAccessToken(accessToken)
        }
    }
}