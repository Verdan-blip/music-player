package ru.kpfu.itis.bagaviev.feed.impl.di

import ru.kpfu.itis.bagaviev.common.di.connector.deps.ComponentDependencies
import ru.kpfu.itis.bagaviev.feed.api.domain.feed.repository.FeatureFeedFeedRepository
import ru.kpfu.itis.bagaviev.feed.api.domain.playlist.repository.FeatureFeedPlaylistRepository
import ru.kpfu.itis.bagaviev.feed.api.domain.track.repository.FeatureFeedTrackRepository
import ru.kpfu.itis.bagaviev.feed.impl.FeedRouter
import ru.kpfu.itis.bagaviev.player.api.domain.interactor.MusicPlayerInteractor

interface FeedComponentDependencies : ComponentDependencies {

    val featureFeedTrackRepository: FeatureFeedTrackRepository

    val featureFeedPlaylistRepository: FeatureFeedPlaylistRepository

    val featureFeedFeedRepository: FeatureFeedFeedRepository

    val musicPlayerInteractor: MusicPlayerInteractor

    val feedRouter: FeedRouter
}
