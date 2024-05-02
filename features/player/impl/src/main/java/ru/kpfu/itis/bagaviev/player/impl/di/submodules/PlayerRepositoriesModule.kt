package ru.kpfu.itis.bagaviev.player.impl.di.submodules

import dagger.Binds
import dagger.Module
import ru.kpfu.itis.bagaviev.player.api.domain.repository.MusicControllerRepository
import ru.kpfu.itis.bagaviev.player.impl.data.repository.MusicControllerRepositoryImpl

@Module
interface PlayerRepositoriesModule {

    @Binds
    fun provideMusicControllerRepositoryImpl_to_MusicControllerRepository(
        musicControllerRepositoryImpl: MusicControllerRepositoryImpl
    ): MusicControllerRepository
}