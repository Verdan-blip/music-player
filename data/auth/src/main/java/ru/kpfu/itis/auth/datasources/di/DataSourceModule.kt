package ru.kpfu.itis.auth.datasources.di

import dagger.Binds
import dagger.Module
import ru.kpfu.itis.auth.datasources.DataSource
import ru.kpfu.itis.auth.datasources.SharedPreferencesDataSource

@Module
interface DataSourceModule {

    @Binds
    fun provideSharedPreferencesDataSource_to_DataSource(
        sharedPreferencesDataSource: SharedPreferencesDataSource
    ): DataSource
}