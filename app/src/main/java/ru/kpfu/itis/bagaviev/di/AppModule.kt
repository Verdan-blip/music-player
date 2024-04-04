package ru.kpfu.itis.bagaviev.di

import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.kpfu.itis.bagaviev.App

@Module
interface AppModule {

    @Binds
    fun provideContext(application: App): Context
}