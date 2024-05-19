package ru.kpfu.itis.bagaviev.features.signup

import ru.kpfu.itis.bagaviev.data.music.api.data.network.auth.repository.AuthDataRepository
import ru.kpfu.itis.bagaviev.feature.signup.domain.entities.SignUpResult
import ru.kpfu.itis.bagaviev.feature.signup.domain.entities.SignUpForm
import ru.kpfu.itis.bagaviev.feature.signup.domain.repository.SignUpRepository
import ru.kpfu.itis.bagaviev.features.signup.mapper.toAuthResult
import ru.kpfu.itis.bagaviev.features.signup.mapper.toRegisterDataEntity
import javax.inject.Inject

class AdapterSignUpRepository @Inject constructor(
    private val authDataRepository: AuthDataRepository
) : SignUpRepository {

    override suspend fun signUp(signUpForm: SignUpForm): SignUpResult =
        authDataRepository.signUp(signUpForm.toRegisterDataEntity())
            .toAuthResult()
}