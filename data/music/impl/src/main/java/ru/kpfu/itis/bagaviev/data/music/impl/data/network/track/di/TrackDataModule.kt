package ru.kpfu.itis.bagaviev.data.music.impl.data.network.track.di

import dagger.Module
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.track.di.submodules.TrackApiServiceModule
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.track.di.submodules.TrackDataRepositoryModule

@Module(
    includes = [
        TrackApiServiceModule::class,
        TrackDataRepositoryModule::class
    ]
)
interface TrackDataModule