package ru.kpfu.itis.bagaviev.data.music.impl.data.network.auth.repository

import dagger.Lazy
import ru.kpfu.itis.bagaviev.data.music.api.data.network.auth.entity.LoginDataEntity
import ru.kpfu.itis.bagaviev.data.music.api.data.network.auth.entity.RegisterDataEntity
import ru.kpfu.itis.bagaviev.data.music.api.data.network.auth.entity.TokenDataEntity
import ru.kpfu.itis.bagaviev.data.music.api.data.network.auth.repository.AuthDataRepository
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.auth.mapper.toAuthResultDataEntity
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.auth.mapper.toLoginRequest
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.auth.mapper.toRegisterRequest
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.auth.pojo.requests.RefreshRequest
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.auth.service.AuthApiService
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.auth.service.AccessTokenApiService
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.auth.service.RefreshTokenApiService
import javax.inject.Inject

class AuthDataRepositoryImpl @Inject constructor(
    private val lazyAuthApiService: Lazy<AuthApiService>,
    private val lazyAccessTokenApiService: Lazy<AccessTokenApiService>,
    private val lazyRefreshTokenApiService: Lazy<RefreshTokenApiService>
) : AuthDataRepository {

    override suspend fun signIn(loginDataEntity: LoginDataEntity): TokenDataEntity =
        lazyAuthApiService.get().signIn(loginDataEntity.toLoginRequest())
            .toAuthResultDataEntity()

    override suspend fun signUp(registerDataEntity: RegisterDataEntity): TokenDataEntity =
        lazyAuthApiService.get().signUp(registerDataEntity.toRegisterRequest())
            .toAuthResultDataEntity()

    override suspend fun getAccessToken(refreshToken: String): TokenDataEntity =
        lazyAccessTokenApiService.get().refreshAccessToken(RefreshRequest(refreshToken))
            .toAuthResultDataEntity()

    override suspend fun refresh(refreshToken: String): TokenDataEntity =
        lazyAccessTokenApiService.get().refreshAccessToken(RefreshRequest(refreshToken))
            .toAuthResultDataEntity()
}