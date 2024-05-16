package ru.kpfu.itis.bagaviev.features.signup

import ru.kpfu.itis.bagaviev.data.music.api.data.local.repository.TokenDataRepository
import ru.kpfu.itis.bagaviev.feature.signup.domain.repository.SignUpTokenRepository
import javax.inject.Inject

class AdapterSignUpTokenRepository @Inject constructor(
    private val tokenDataRepository: TokenDataRepository
) : SignUpTokenRepository {

    override suspend fun saveAccessToken(accessToken: String) {
        tokenDataRepository.saveAccessToken(accessToken)
    }

    override suspend fun saveRefreshToken(refreshToken: String) {
        tokenDataRepository.saveRefreshToken(refreshToken)
    }
}