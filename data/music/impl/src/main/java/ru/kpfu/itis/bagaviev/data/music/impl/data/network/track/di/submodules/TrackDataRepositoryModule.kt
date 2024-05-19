package ru.kpfu.itis.bagaviev.data.music.impl.data.network.track.di.submodules

import dagger.Binds
import dagger.Module
import ru.kpfu.itis.bagaviev.data.music.api.data.network.track.repository.TracksDataRepository
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.track.repository.TrackDataRepositoryImpl

@Module
interface TrackDataRepositoryModule {

    @Binds
    fun provideTracksDataRepositoryImpl_to_TrackDataRepository(
        trackDataRepositoryImpl: TrackDataRepositoryImpl
    ): TracksDataRepository
}