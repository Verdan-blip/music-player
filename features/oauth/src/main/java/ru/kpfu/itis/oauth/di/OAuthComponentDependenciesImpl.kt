package ru.kpfu.itis.oauth.di

import ru.kpfu.itis.oauth.OAuthRouter
import ru.kpfu.itis.oauth.domain.entities.GrantedTokenData
import ru.kpfu.itis.oauth.domain.repository.AuthTokenRepository
import ru.kpfu.itis.oauth.domain.repository.OAuthRepository
import java.net.URI

class OAuthComponentDependenciesImpl : OAuthComponentDependencies {

    override fun getAuthTokenRepository(): AuthTokenRepository {
        return object : AuthTokenRepository {

            override suspend fun saveAccessToken(accessToken: String) = Unit

            override suspend fun getAccessToken(): String? = null
        }
    }

    override fun getOAuthRepository(): OAuthRepository {
        return object : OAuthRepository {
            override suspend fun getOAuthUri(): URI = URI("https://site.com")

            override suspend fun getGrantedTokenData(code: String): GrantedTokenData =
                GrantedTokenData("access_token", "refresh_token")
        }
    }

    override fun getOAuthRouter(): OAuthRouter =
        object : OAuthRouter {
            override fun openMainScreen() = Unit
        }

}