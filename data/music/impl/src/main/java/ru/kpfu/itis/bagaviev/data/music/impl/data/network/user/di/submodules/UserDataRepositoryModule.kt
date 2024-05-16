package ru.kpfu.itis.bagaviev.data.music.impl.data.network.user.di.submodules

import dagger.Binds
import dagger.Module
import ru.kpfu.itis.bagaviev.data.music.api.data.network.user.repository.UserDataRepository
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.user.repository.UserDataRepositoryImpl

@Module
interface UserDataRepositoryModule {

    @Binds
    fun provideUserDataRepositoryImpl_to_UserDataRepository(
        userDataRepositoryImpl: UserDataRepositoryImpl
    ): UserDataRepository
}