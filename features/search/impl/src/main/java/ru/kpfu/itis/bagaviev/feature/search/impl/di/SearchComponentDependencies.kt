package ru.kpfu.itis.bagaviev.feature.search.impl.di

import ru.kpfu.itis.bagaviev.common.di.connector.deps.ComponentDependencies
import ru.kpfu.itis.bagaviev.data.music.api.data.network.playlist.repository.PlaylistsDataRepository
import ru.kpfu.itis.bagaviev.data.music.api.data.network.search.repository.SearchDataRepository
import ru.kpfu.itis.bagaviev.data.music.api.data.network.track.repository.TracksDataRepository
import ru.kpfu.itis.bagaviev.player.api.domain.interactor.MusicPlayerInteractor

interface SearchComponentDependencies : ComponentDependencies {

    val trackRepository: TracksDataRepository

    val playlistRepository: PlaylistsDataRepository

    val searchDataRepository: SearchDataRepository

    val musicPlayerInteractor: MusicPlayerInteractor
}