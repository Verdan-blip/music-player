package ru.kpfu.itis.bagaviev.di

import android.content.Context
import dagger.Binds
import dagger.Module
import ru.kpfu.itis.bagaviev.App
import ru.kpfu.itis.bagaviev.navigation.di.NavigationModule

@Module(
    includes = [
        NavigationModule::class
    ]
)
interface AppModule {

    @Binds
    fun provideContext(application: App): Context
}