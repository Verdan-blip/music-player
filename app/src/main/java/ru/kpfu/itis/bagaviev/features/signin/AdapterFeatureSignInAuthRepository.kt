package ru.kpfu.itis.bagaviev.features.signin

import ru.kpfu.itis.bagaviev.data.music.api.data.network.auth.repository.AuthDataRepository
import ru.kpfu.itis.bagaviev.feature.signin.domain.entity.SignInResult
import ru.kpfu.itis.bagaviev.feature.signin.domain.entity.SignInForm
import ru.kpfu.itis.bagaviev.feature.signin.domain.repository.FeatureSignInAuthRepository
import ru.kpfu.itis.bagaviev.features.signin.mapper.toAuthResult
import ru.kpfu.itis.bagaviev.features.signin.mapper.toRegisterDataEntity
import javax.inject.Inject

class AdapterFeatureSignInAuthRepository @Inject constructor(
    private val authDataRepository: AuthDataRepository
) : FeatureSignInAuthRepository {

    override suspend fun signIn(signInForm: SignInForm): SignInResult =
        authDataRepository.signIn(signInForm.toRegisterDataEntity())
            .toAuthResult()
}