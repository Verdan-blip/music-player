package ru.kpfu.itis.oauth.domain.usecase

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import ru.kpfu.itis.common.di.modules.IODispatcher
import ru.kpfu.itis.oauth.domain.repository.OAuthRepository
import java.net.URI
import javax.inject.Inject

class GetOAuthUriUseCase @Inject constructor(
    private val oAuthRepository: OAuthRepository,
    @IODispatcher private val dispatcher: CoroutineDispatcher
) {

    suspend operator fun invoke(): URI {
        return withContext(dispatcher) {
            oAuthRepository.getOAuthUri()
        }
    }

}