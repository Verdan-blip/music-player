package ru.kpfu.itis.bagaviev.feed.impl.di

import ru.kpfu.itis.bagaviev.common.di.connector.deps.ComponentDependencies
import ru.kpfu.itis.bagaviev.data.music.api.data.playlists.repository.PlaylistsDataRepository
import ru.kpfu.itis.bagaviev.data.music.api.data.tracks.repository.TracksDataRepository
import ru.kpfu.itis.bagaviev.feed.api.domain.playlists.repository.PlaylistRepository
import ru.kpfu.itis.bagaviev.feed.api.domain.tracks.repository.TrackRepository
import ru.kpfu.itis.bagaviev.feed.impl.FeedRouter
import ru.kpfu.itis.bagaviev.player.api.domain.interactor.MusicPlayerInteractor

interface FeedComponentDependencies : ComponentDependencies {

    val trackRepository: TracksDataRepository

    val playlistRepository: PlaylistsDataRepository

    val musicPlayerInteractor: MusicPlayerInteractor

    val feedRouter: FeedRouter
}
