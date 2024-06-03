package ru.kpfu.itis.bagaviev.feature.upload.domain.usecase

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import ru.kpfu.itis.bagaviev.common.di.modules.IODispatcher
import ru.kpfu.itis.bagaviev.feature.upload.domain.entity.AuthorFeed
import ru.kpfu.itis.bagaviev.feature.upload.domain.repository.FeatureUploadAuthRepository
import javax.inject.Inject

class GetCurrentUserUseCase @Inject constructor(
    private val authRepository: FeatureUploadAuthRepository,
    @IODispatcher private val coroutineDispatcher: CoroutineDispatcher
) {

    suspend operator fun invoke(): Result<AuthorFeed> =
        runCatching {
            withContext(coroutineDispatcher) {
                authRepository.getCurrentUser()
            }
    }
}