package ru.kpfu.itis.bagaviev.impl.di.submodules

import dagger.Binds
import dagger.Module
import ru.kpfu.itis.bagaviev.api.domain.repository.MusicControllerRepository
import ru.kpfu.itis.bagaviev.impl.data.repository.MusicControllerRepositoryImpl
import ru.kpfu.itis.common.di.scopes.FeatureScope

@Module
interface PlayerRepositoriesModule {

    @Binds
    fun provideMusicControllerRepositoryImpl_to_MusicControllerRepository(
        musicControllerRepositoryImpl: MusicControllerRepositoryImpl
    ): MusicControllerRepository
}