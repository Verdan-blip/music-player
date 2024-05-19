package ru.kpfu.itis.bagaviev.features.signin

import ru.kpfu.itis.bagaviev.data.music.api.data.network.auth.repository.AuthDataRepository
import ru.kpfu.itis.bagaviev.feature.signin.domain.entities.SignInResult
import ru.kpfu.itis.bagaviev.feature.signin.domain.entities.SignInForm
import ru.kpfu.itis.bagaviev.feature.signin.domain.repository.SignInRepository
import ru.kpfu.itis.bagaviev.features.signin.mapper.toAuthResult
import ru.kpfu.itis.bagaviev.features.signin.mapper.toRegisterDataEntity
import javax.inject.Inject

class AdapterSignInRepository @Inject constructor(
    private val authDataRepository: AuthDataRepository
) : SignInRepository {

    override suspend fun signIn(signInForm: SignInForm): SignInResult =
        authDataRepository.signIn(signInForm.toRegisterDataEntity())
            .toAuthResult()
}