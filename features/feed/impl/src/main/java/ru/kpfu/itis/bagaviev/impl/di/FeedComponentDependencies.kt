package ru.kpfu.itis.bagaviev.impl.di

import ru.kpfu.itis.bagaviev.api.domain.playlists.repository.PlaylistRepository
import ru.kpfu.itis.bagaviev.api.domain.tracks.repository.TrackRepository
import ru.kpfu.itis.bagaviev.impl.TracksPlaylistsController
import ru.kpfu.itis.common.di.connector.deps.ComponentDependencies

interface FeedComponentDependencies : ComponentDependencies {

    fun tracksPlaylistsController(): TracksPlaylistsController

    fun trackRepository(): TrackRepository

    fun playlistRepository(): PlaylistRepository
}
