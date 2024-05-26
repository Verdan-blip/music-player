package ru.kpfu.itis.bagaviev.feature.signup.domain.usecases

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import ru.kpfu.itis.bagaviev.common.di.modules.IODispatcher
import ru.kpfu.itis.bagaviev.feature.signup.domain.entity.SignUpResult
import ru.kpfu.itis.bagaviev.feature.signup.domain.entity.SignUpForm
import ru.kpfu.itis.bagaviev.feature.signup.domain.repository.FeatureSignUpAuthRepository
import javax.inject.Inject

class SignUpUseCase @Inject constructor(
    private val featureSignUpAuthRepository: FeatureSignUpAuthRepository,
    @IODispatcher private val dispatcher: CoroutineDispatcher
) {

    suspend operator fun invoke(signUpForm: SignUpForm): Result<SignUpResult> =
        runCatching {
            withContext(dispatcher) {
                featureSignUpAuthRepository.signUp(signUpForm)
            }
        }
}