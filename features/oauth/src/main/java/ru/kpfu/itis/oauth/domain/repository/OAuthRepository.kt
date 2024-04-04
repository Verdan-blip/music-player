package ru.kpfu.itis.oauth.domain.repository

import ru.kpfu.itis.oauth.domain.entities.GrantedTokenData
import java.net.URI

interface OAuthRepository {

    suspend fun getOAuthUri(): URI

    suspend fun getGrantedTokenData(code: String): GrantedTokenData

}