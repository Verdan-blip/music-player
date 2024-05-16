package ru.kpfu.itis.bagaviev.feature.signin.domain.usecase

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import ru.kpfu.itis.bagaviev.common.di.modules.IODispatcher
import ru.kpfu.itis.bagaviev.feature.signin.domain.entities.SignInResult
import ru.kpfu.itis.bagaviev.feature.signin.domain.entities.SignInForm
import ru.kpfu.itis.bagaviev.feature.signin.domain.repository.SignInRepository
import javax.inject.Inject

class SignInUseCase @Inject constructor(
    private val signInRepository: SignInRepository,
    @IODispatcher private val coroutineDispatcher: CoroutineDispatcher
) {

    suspend operator fun invoke(signInForm: SignInForm): Result<SignInResult> =
        runCatching {
            withContext(coroutineDispatcher) {
                signInRepository.signIn(signInForm)
            }
        }
}