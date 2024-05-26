package ru.kpfu.itis.bagaviev.feature.search.impl.di.submodules

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import ru.kpfu.itis.bagaviev.common.di.modules.CoroutineDispatcherModule
import ru.kpfu.itis.bagaviev.common.di.modules.IODispatcher
import ru.kpfu.itis.bagaviev.feature.search.api.domain.playlists.repository.FeatureSearchPlaylistRepository
import ru.kpfu.itis.bagaviev.feature.search.api.domain.playlists.usecase.GetPlaylistDetailsByIdUseCase
import ru.kpfu.itis.bagaviev.feature.search.api.domain.search.repository.FeatureSearchSearchRepository
import ru.kpfu.itis.bagaviev.feature.search.api.domain.search.usecase.SearchByKeywordsUseCase
import ru.kpfu.itis.bagaviev.feature.search.api.domain.track.repository.FeatureSearchTrackRepository
import ru.kpfu.itis.bagaviev.feature.search.api.domain.track.usecase.GetTrackDetailsByIdUseCase

@Module(
    includes = [
        CoroutineDispatcherModule::class
    ]
)
internal class UseCasesModule {

    @Provides
    fun provideGetPlaylistDetailsByIdUseCase(
        featureSearchPlaylistRepository: FeatureSearchPlaylistRepository,
        @IODispatcher coroutineDispatcher: CoroutineDispatcher
    ): GetPlaylistDetailsByIdUseCase =
        GetPlaylistDetailsByIdUseCase(featureSearchPlaylistRepository, coroutineDispatcher)

    @Provides
    fun provideSearchByKeywords(
        featureSearchSearchRepository: FeatureSearchSearchRepository,
        @IODispatcher coroutineDispatcher: CoroutineDispatcher
    ): SearchByKeywordsUseCase =
        SearchByKeywordsUseCase(featureSearchSearchRepository, coroutineDispatcher)

    @Provides
    fun provideGetTrackDetailsByIdUseCase(
        featureSearchTrackRepository: FeatureSearchTrackRepository,
        @IODispatcher coroutineDispatcher: CoroutineDispatcher
    ): GetTrackDetailsByIdUseCase =
        GetTrackDetailsByIdUseCase(featureSearchTrackRepository, coroutineDispatcher)

}