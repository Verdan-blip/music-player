package ru.kpfu.itis.bagaviev.player.impl.di

import dagger.Binds
import dagger.Module
import ru.kpfu.itis.bagaviev.player.api.domain.repository.MusicPlayerRepository
import ru.kpfu.itis.bagaviev.player.impl.data.impl.MusicPlayerRepositoryImpl

@Module
interface PlayerRepositoryModule {

    @Binds
    fun provideMusicRepositoryModule(
        musicPlayerRepository: MusicPlayerRepositoryImpl
    ): MusicPlayerRepository
}