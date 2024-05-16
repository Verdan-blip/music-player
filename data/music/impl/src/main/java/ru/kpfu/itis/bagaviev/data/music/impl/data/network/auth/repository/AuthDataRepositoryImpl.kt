package ru.kpfu.itis.bagaviev.data.music.impl.data.network.auth.repository

import ru.kpfu.itis.bagaviev.data.music.api.data.network.auth.entities.LoginDataEntity
import ru.kpfu.itis.bagaviev.data.music.api.data.network.auth.entities.RegisterDataEntity
import ru.kpfu.itis.bagaviev.data.music.api.data.network.auth.entities.TokenDataEntity
import ru.kpfu.itis.bagaviev.data.music.api.data.network.auth.repositories.AuthDataRepository
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.auth.mapper.toAuthResultDataEntity
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.auth.mapper.toLoginRequest
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.auth.mapper.toRegisterRequest
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.auth.service.AuthApiService
import javax.inject.Inject

class AuthDataRepositoryImpl @Inject constructor(
    private val authApiService: AuthApiService
) : AuthDataRepository {

    override suspend fun signIn(loginDataEntity: LoginDataEntity): TokenDataEntity =
        authApiService.signIn(loginDataEntity.toLoginRequest())
            .toAuthResultDataEntity()

    override suspend fun signUp(registerDataEntity: RegisterDataEntity): TokenDataEntity =
        authApiService.signUp(registerDataEntity.toRegisterRequest())
            .toAuthResultDataEntity()

    override suspend fun refreshAccessToken(refreshToken: String): TokenDataEntity =
        authApiService.refreshAccessToken(refreshToken)
            .toAuthResultDataEntity()
}