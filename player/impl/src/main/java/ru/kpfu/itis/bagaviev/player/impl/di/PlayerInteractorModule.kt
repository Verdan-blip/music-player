package ru.kpfu.itis.bagaviev.player.impl.di

import dagger.Binds
import dagger.Module
import ru.kpfu.itis.bagaviev.player.api.domain.interactor.MusicPlayerInteractor
import ru.kpfu.itis.bagaviev.player.impl.data.impl.MusicPlayerInteractorImpl

@Module
interface PlayerInteractorModule {

    @Binds
    fun provideMusicPlayerInteractorImpl_to_MusicPlayerInteractor(
        musicPlayerInteractor: MusicPlayerInteractorImpl
    ): MusicPlayerInteractor
}