package ru.kpfu.itis.oauth.domain.usecase

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import ru.kpfu.itis.bagaviev.common.di.modules.IODispatcher
import ru.kpfu.itis.oauth.domain.entities.GrantedTokenData
import ru.kpfu.itis.oauth.domain.repository.OAuthRepository
import javax.inject.Inject

class GrantAccessTokenUseCase @Inject constructor(
    private val oAuthRepository: OAuthRepository,
    @IODispatcher private val dispatcher: CoroutineDispatcher
) {

    suspend operator fun invoke(code: String): GrantedTokenData {
        return withContext(dispatcher) {
            oAuthRepository.getGrantedTokenData(code)
        }
    }

}