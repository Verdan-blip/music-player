package ru.kpfu.itis.bagaviev.feature.upload.domain.usecase

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import ru.kpfu.itis.bagaviev.common.di.modules.IODispatcher
import ru.kpfu.itis.bagaviev.feature.upload.domain.entity.AuthorFeed
import ru.kpfu.itis.bagaviev.feature.upload.domain.repository.FeatureUploadSearchRepository
import javax.inject.Inject

class SearchUsersByKeywordsUseCase @Inject constructor(
    private val searchUserRepository: FeatureUploadSearchRepository,
    @IODispatcher private val coroutineDispatcher: CoroutineDispatcher
) {

    suspend operator fun invoke(keywords: List<String>): Result<List<AuthorFeed>> =
        runCatching {
            withContext(coroutineDispatcher) {
                searchUserRepository.searchUsersByKeywords(keywords)
            }
        }
}