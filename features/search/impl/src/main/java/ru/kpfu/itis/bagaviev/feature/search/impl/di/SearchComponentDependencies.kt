package ru.kpfu.itis.bagaviev.feature.search.impl.di

import ru.kpfu.itis.bagaviev.common.di.connector.deps.ComponentDependencies
import ru.kpfu.itis.bagaviev.feature.search.api.domain.playlists.repository.FeatureSearchPlaylistRepository
import ru.kpfu.itis.bagaviev.feature.search.api.domain.search.repository.FeatureSearchSearchRepository
import ru.kpfu.itis.bagaviev.feature.search.api.domain.track.repository.FeatureSearchTrackRepository
import ru.kpfu.itis.bagaviev.player.api.domain.interactor.MusicPlayerInteractor

interface SearchComponentDependencies : ComponentDependencies {

    val featureSearchTrackRepository: FeatureSearchTrackRepository

    val featureSearchPlaylistRepository: FeatureSearchPlaylistRepository

    val featureSearchSearchRepository: FeatureSearchSearchRepository

    val musicPlayerInteractor: MusicPlayerInteractor
}