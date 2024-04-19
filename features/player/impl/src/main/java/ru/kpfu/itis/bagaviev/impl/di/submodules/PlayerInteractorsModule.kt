package ru.kpfu.itis.bagaviev.impl.di.submodules

import dagger.Module
import dagger.Provides
import ru.kpfu.itis.bagaviev.api.domain.interactor.MusicControllerInteractor
import ru.kpfu.itis.bagaviev.api.domain.repository.MusicControllerRepository
import ru.kpfu.itis.common.di.modules.CoroutineDispatcherModule

@Module(
    includes = [CoroutineDispatcherModule::class]
)
class PlayerInteractorsModule {

    @Provides
    fun provideMusicControllerInteractor(
        musicControllerRepository: MusicControllerRepository
    ): MusicControllerInteractor =
        MusicControllerInteractor(musicControllerRepository)
}