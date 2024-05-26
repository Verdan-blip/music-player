package ru.kpfu.itis.bagaviev.data.music.impl.data.local.token.repository

import ru.kpfu.itis.bagaviev.data.music.api.data.local.token.repository.TokenDataRepository
import ru.kpfu.itis.bagaviev.data.music.impl.data.local.token.datasource.TokenDataSource
import javax.inject.Inject

class SharedPreferencesTokenDataRepository @Inject constructor(
    private val tokenDataSource: TokenDataSource
) : TokenDataRepository {

    override fun getAccessToken(): String? =
        tokenDataSource.getAccessToken()

    override fun getRefreshToken(): String? =
        tokenDataSource.getRefreshToken()

    override fun getExpiration(): Long? =
        tokenDataSource.getExpiration()

    override fun saveAccessToken(accessToken: String) {
        tokenDataSource.saveAccessToken(accessToken)
    }

    override fun saveRefreshToken(refreshToken: String) {
        tokenDataSource.saveRefreshToken(refreshToken)
    }

    override fun saveExpiration(expiresAt: Long) {
        tokenDataSource.saveExpiration(expiresAt)
    }
}