package ru.kpfu.itis.bagaviev.player.impl.di.submodules

import dagger.Binds
import dagger.Module
import ru.kpfu.itis.bagaviev.player.api.domain.repository.MusicDownloadRepository
import ru.kpfu.itis.bagaviev.player.api.domain.repository.MusicPlayerRepository
import ru.kpfu.itis.bagaviev.player.impl.data.impl.MusicDownloadRepositoryImpl
import ru.kpfu.itis.bagaviev.player.impl.data.impl.MusicPlayerRepositoryImpl

@Module
interface PlayerRepositoryModule {

    @Binds
    fun provideMusicPlayerRepositoryImpl_to_MusicPlayerRepository(
        musicPlayerRepository: MusicPlayerRepositoryImpl
    ): MusicPlayerRepository

    @Binds
    fun provideMusicDownloadRepositoryImpl_to_MusicDownloadRepository(
        musicDownloadRepositoryImpl: MusicDownloadRepositoryImpl
    ): MusicDownloadRepository
}