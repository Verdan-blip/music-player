package ru.kpfu.itis.bagaviev.player.impl.di.submodules

import dagger.Binds
import dagger.Module
import ru.kpfu.itis.bagaviev.player.api.domain.interactor.MusicControllerInteractor
import ru.kpfu.itis.bagaviev.player.impl.domain.interactor.MusicControllerInteractorImpl
import ru.kpfu.itis.common.di.modules.CoroutineDispatcherModule

@Module(
    includes = [CoroutineDispatcherModule::class]
)
interface PlayerInteractorsModule {

    @Binds
    fun provideMusicControllerInteractorImpl_to_MusicControllerInteractor(
        musicControllerInteractorImpl: MusicControllerInteractorImpl
    ): MusicControllerInteractor
}