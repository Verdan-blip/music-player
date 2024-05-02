package ru.kpfu.itis.bagaviev.feed.impl.di

import ru.kpfu.itis.bagaviev.feed.api.domain.playlists.repository.PlaylistRepository
import ru.kpfu.itis.bagaviev.feed.api.domain.tracks.repository.TrackRepository
import ru.kpfu.itis.bagaviev.feed.impl.FeedRouter
import ru.kpfu.itis.bagaviev.feed.impl.TracksPlaylistsController
import ru.kpfu.itis.common.di.connector.deps.ComponentDependencies

interface FeedComponentDependencies : ComponentDependencies {

    fun tracksPlaylistsController(): TracksPlaylistsController

    fun trackRepository(): TrackRepository

    fun playlistRepository(): PlaylistRepository

    fun feedRouter(): FeedRouter
}
