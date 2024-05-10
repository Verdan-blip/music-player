package ru.kpfu.itis.bagaviev.feature.search.impl.di

import ru.kpfu.itis.bagaviev.common.di.connector.deps.ComponentDependencies
import ru.kpfu.itis.bagaviev.data.music.api.data.playlists.repository.PlaylistsDataRepository
import ru.kpfu.itis.bagaviev.data.music.api.data.tracks.repository.TracksDataRepository
import ru.kpfu.itis.bagaviev.player.api.domain.interactor.MusicPlayerInteractor

interface SearchComponentDependencies : ComponentDependencies {

    val trackRepository: TracksDataRepository

    val playlistRepository: PlaylistsDataRepository

    val musicPlayerInteractor: MusicPlayerInteractor
}