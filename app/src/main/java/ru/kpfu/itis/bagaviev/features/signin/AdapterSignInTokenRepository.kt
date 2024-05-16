package ru.kpfu.itis.bagaviev.features.signin

import dagger.Module
import ru.kpfu.itis.bagaviev.data.music.api.data.local.repository.TokenDataRepository
import ru.kpfu.itis.bagaviev.feature.signin.domain.repository.SignInTokenRepository
import javax.inject.Inject

@Module
class AdapterSignInTokenRepository @Inject constructor(
    private val tokenDataRepository: TokenDataRepository
) : SignInTokenRepository {

    override suspend fun saveAccessToken(accessToken: String) {
        tokenDataRepository.saveAccessToken(accessToken)
    }

    override suspend fun saveRefreshToken(refreshToken: String) {
        tokenDataRepository.saveRefreshToken(refreshToken)
    }
}