package ru.kpfu.itis.bagaviev.features.signup

import ru.kpfu.itis.bagaviev.data.music.api.data.local.token.repository.TokenDataRepository
import ru.kpfu.itis.bagaviev.feature.signup.domain.repository.FeatureSignUpTokenRepository
import javax.inject.Inject

class AdapterFeatureSignUpTokenRepository @Inject constructor(
    private val tokenDataRepository: TokenDataRepository
) : FeatureSignUpTokenRepository {

    override suspend fun saveAccessToken(accessToken: String) {
        tokenDataRepository.saveAccessToken(accessToken)
    }

    override suspend fun saveRefreshToken(refreshToken: String) {
        tokenDataRepository.saveRefreshToken(refreshToken)
    }
}