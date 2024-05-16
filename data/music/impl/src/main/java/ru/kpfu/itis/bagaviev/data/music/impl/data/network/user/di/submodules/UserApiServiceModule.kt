package ru.kpfu.itis.bagaviev.data.music.impl.data.network.user.di.submodules

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.user.service.UserApiService

@Module
class UserApiServiceModule {

    @Provides
    fun provideUserApiService(retrofit: Retrofit): UserApiService =
        retrofit.create(UserApiService::class.java)
}