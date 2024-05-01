package ru.kpfu.itis.bagaviev.glue.feed.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.kpfu.itis.bagaviev.api.domain.playlists.repository.PlaylistRepository
import ru.kpfu.itis.bagaviev.api.domain.tracks.repository.TrackRepository
import ru.kpfu.itis.bagaviev.glue.feed.AdapterPlaylistRepository
import ru.kpfu.itis.bagaviev.glue.feed.AdapterTrackRepository
import ru.kpfu.itis.bagaviev.glue.feed.AdapterTracksPlaylistsController
import ru.kpfu.itis.bagaviev.impl.TracksPlaylistsController
import ru.kpfu.itis.bagaviev.impl.di.PlayerModule

@Module(
    includes = [PlayerModule::class]
)
interface FeedMusicControllerModule {

    @Binds
    fun provideTracksPlaylistsController(
        adapterTracksPlaylistsController: AdapterTracksPlaylistsController
    ): TracksPlaylistsController
}