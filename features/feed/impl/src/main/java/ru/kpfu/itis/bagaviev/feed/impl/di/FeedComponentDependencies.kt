package ru.kpfu.itis.bagaviev.feed.impl.di

import ru.kpfu.itis.bagaviev.common.di.connector.deps.ComponentDependencies
import ru.kpfu.itis.bagaviev.data.music.api.data.network.feed.repository.FeedDataRepository
import ru.kpfu.itis.bagaviev.data.music.api.data.network.playlist.repository.PlaylistsDataRepository
import ru.kpfu.itis.bagaviev.data.music.api.data.network.track.repository.TracksDataRepository
import ru.kpfu.itis.bagaviev.feed.impl.FeedRouter
import ru.kpfu.itis.bagaviev.player.api.domain.interactor.MusicPlayerInteractor

interface FeedComponentDependencies : ComponentDependencies {

    val trackDataRepository: TracksDataRepository

    val playlistDataRepository: PlaylistsDataRepository

    val feedDataRepository: FeedDataRepository

    val musicPlayerInteractor: MusicPlayerInteractor

    val feedRouter: FeedRouter
}
