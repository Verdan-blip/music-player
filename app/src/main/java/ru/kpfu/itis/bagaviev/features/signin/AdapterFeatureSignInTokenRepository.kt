package ru.kpfu.itis.bagaviev.features.signin

import dagger.Module
import ru.kpfu.itis.bagaviev.data.music.api.data.local.token.repository.TokenDataRepository
import ru.kpfu.itis.bagaviev.feature.signin.domain.repository.FeatureSignInTokenRepository
import javax.inject.Inject

@Module
class AdapterFeatureSignInTokenRepository @Inject constructor(
    private val tokenDataRepository: TokenDataRepository
) : FeatureSignInTokenRepository {

    override suspend fun saveAccessToken(accessToken: String) {
        tokenDataRepository.saveAccessToken(accessToken)
    }

    override suspend fun saveRefreshToken(refreshToken: String) {
        tokenDataRepository.saveRefreshToken(refreshToken)
    }
}