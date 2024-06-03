package ru.kpfu.itis.bagaviev.feature.signin.domain.usecase

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import ru.kpfu.itis.bagaviev.common.di.modules.IODispatcher
import ru.kpfu.itis.bagaviev.feature.signin.domain.entity.SignInResult
import ru.kpfu.itis.bagaviev.feature.signin.domain.entity.SignInForm
import ru.kpfu.itis.bagaviev.feature.signin.domain.repository.FeatureSignInAuthRepository
import javax.inject.Inject

class SignInUseCase @Inject constructor(
    private val featureSignInAuthRepository: FeatureSignInAuthRepository,
    @IODispatcher private val coroutineDispatcher: CoroutineDispatcher
) {

    suspend operator fun invoke(signInForm: SignInForm): Result<SignInResult> =
        runCatching {
            withContext(coroutineDispatcher) {
                featureSignInAuthRepository.signIn(signInForm)
            }
        }
}