package ru.kpfu.itis.bagaviev.di

import android.content.Context
import dagger.Binds
import dagger.Module
import ru.kpfu.itis.bagaviev.App
import ru.kpfu.itis.bagaviev.music.di.DataModule
import ru.kpfu.itis.bagaviev.navigation.di.NavigationModule

@Module(
    includes = [
        DataModule::class,
        NavigationModule::class
    ]
)
interface AppModule {

    @Binds
    fun provideContext(application: App): Context
}