package ru.kpfu.itis.bagaviev.data.music.impl.data.local.di

import dagger.Binds
import dagger.Module
import ru.kpfu.itis.bagaviev.data.music.impl.data.local.datasource.SharedPreferencesTokenDatasource
import ru.kpfu.itis.bagaviev.data.music.impl.data.local.datasource.TokenDataSource

@Module
interface LocalDatasourceModule {

    @Binds
    fun provideSharedPreferencesTokenDatasource_to_TokenDatasource(
        sharedPreferencesTokenDatasource: SharedPreferencesTokenDatasource
    ): TokenDataSource
}