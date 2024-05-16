package ru.kpfu.itis.bagaviev.features.oauth

import ru.kpfu.itis.oauth.domain.entities.GrantedTokenData
import ru.kpfu.itis.oauth.domain.repository.OAuthRepository
import java.net.URI
import javax.inject.Inject

class AdapterOAuthRepository @Inject constructor() : OAuthRepository {

    override suspend fun getOAuthUri(): URI =
        URI.create("www.lox.com")

    override suspend fun getGrantedTokenData(code: String): GrantedTokenData =
        GrantedTokenData(
            accessToken = "lox",
            refreshToken = "lox"
        )

}