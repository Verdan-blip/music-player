package ru.kpfu.itis.bagaviev.feature.signup.domain.usecases

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import ru.kpfu.itis.bagaviev.common.di.modules.IODispatcher
import ru.kpfu.itis.bagaviev.feature.signup.domain.entities.SignUpResult
import ru.kpfu.itis.bagaviev.feature.signup.domain.entities.SignUpForm
import ru.kpfu.itis.bagaviev.feature.signup.domain.repository.SignUpRepository
import javax.inject.Inject

class SignUpUseCase @Inject constructor(
    private val signUpRepository: SignUpRepository,
    @IODispatcher private val dispatcher: CoroutineDispatcher
) {

    suspend operator fun invoke(signUpForm: SignUpForm): Result<SignUpResult> =
        runCatching {
            withContext(dispatcher) {
                signUpRepository.signUp(signUpForm)
            }
        }
}