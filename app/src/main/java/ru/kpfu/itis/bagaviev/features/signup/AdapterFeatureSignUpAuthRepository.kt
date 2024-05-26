package ru.kpfu.itis.bagaviev.features.signup

import ru.kpfu.itis.bagaviev.data.music.api.data.network.auth.repository.AuthDataRepository
import ru.kpfu.itis.bagaviev.feature.signup.domain.entity.SignUpResult
import ru.kpfu.itis.bagaviev.feature.signup.domain.entity.SignUpForm
import ru.kpfu.itis.bagaviev.feature.signup.domain.repository.FeatureSignUpAuthRepository
import ru.kpfu.itis.bagaviev.features.signup.mapper.toAuthResult
import ru.kpfu.itis.bagaviev.features.signup.mapper.toRegisterDataEntity
import javax.inject.Inject

class AdapterFeatureSignUpAuthRepository @Inject constructor(
    private val authDataRepository: AuthDataRepository
) : FeatureSignUpAuthRepository {

    override suspend fun signUp(signUpForm: SignUpForm): SignUpResult =
        authDataRepository.signUp(signUpForm.toRegisterDataEntity())
            .toAuthResult()
}