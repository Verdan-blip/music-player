package ru.kpfu.itis.bagaviev.feature.signin.domain.usecase

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import ru.kpfu.itis.bagaviev.common.di.modules.IODispatcher
import ru.kpfu.itis.bagaviev.feature.signin.domain.repository.SignInTokenRepository
import javax.inject.Inject

class SaveTokensUseCase @Inject constructor(
    private val tokenRepository: SignInTokenRepository,
    @IODispatcher private val coroutineDispatcher: CoroutineDispatcher
) {

    suspend operator fun invoke(
        accessToken: String,
        refreshToken: String
    )  {
        withContext(coroutineDispatcher) {
            tokenRepository.saveAccessToken(accessToken)
            tokenRepository.saveRefreshToken(refreshToken)
        }
    }
}