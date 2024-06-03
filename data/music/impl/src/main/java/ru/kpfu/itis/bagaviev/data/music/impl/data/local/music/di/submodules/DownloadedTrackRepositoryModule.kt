package ru.kpfu.itis.bagaviev.data.music.impl.data.local.music.di.submodules

import dagger.Binds
import dagger.Module
import ru.kpfu.itis.bagaviev.data.music.api.data.local.music.repository.DownloadedTrackDataRepository
import ru.kpfu.itis.bagaviev.data.music.impl.data.local.music.repository.DownloadedTrackDataRepositoryImpl

@Module
interface DownloadedTrackRepositoryModule {

    @Binds
    fun provideDownloadTrackRepositoryImpl_to_DownloadTrackRepository(
        downloadedTrackRepositoryImpl: DownloadedTrackDataRepositoryImpl
    ): DownloadedTrackDataRepository
}