package ru.kpfu.itis.bagaviev.data.music.impl.data.network.playlist.di

import dagger.Module
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.playlist.di.submodules.PlaylistApiServiceDataModule
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.playlist.di.submodules.PlaylistRepositoryDataModule

@Module(
    includes = [
        PlaylistApiServiceDataModule::class,
        PlaylistRepositoryDataModule::class
    ]
)
interface PlaylistDataModule