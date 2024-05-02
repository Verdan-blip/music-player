package ru.kpfu.itis.bagaviev.glue.feed.di

import dagger.Binds
import dagger.Module
import ru.kpfu.itis.bagaviev.feed.impl.TracksPlaylistsController
import ru.kpfu.itis.bagaviev.glue.feed.AdapterTracksPlaylistsController
import ru.kpfu.itis.bagaviev.player.impl.di.PlayerModule

@Module(
    includes = [PlayerModule::class]
)
interface FeedMusicControllerModule {

    @Binds
    fun provideTracksPlaylistsController(
        adapterTracksPlaylistsController: AdapterTracksPlaylistsController
    ): TracksPlaylistsController
}