package ru.kpfu.itis.oauth.domain.usecase

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import ru.kpfu.itis.bagaviev.common.di.modules.IODispatcher
import ru.kpfu.itis.oauth.domain.repository.AuthTokenRepository
import javax.inject.Inject

class SaveAccessTokenUseCase @Inject constructor(
    private val authTokenRepository: AuthTokenRepository,
    @IODispatcher private val dispatcher: CoroutineDispatcher
) {

    suspend operator fun invoke(accessToken: String) {
        withContext(dispatcher) {
            authTokenRepository.saveAccessToken(accessToken)
        }
    }

}