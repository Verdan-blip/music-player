package ru.kpfu.itis.bagaviev.data.music.impl.data.local.token.di

import dagger.Binds
import dagger.Module
import ru.kpfu.itis.bagaviev.data.music.impl.data.local.token.datasource.SharedPreferencesTokenDatasource
import ru.kpfu.itis.bagaviev.data.music.impl.data.local.token.datasource.TokenDataSource

@Module
interface LocalDatasourceModule {

    @Binds
    fun provideSharedPreferencesTokenDatasource_to_TokenDatasource(
        sharedPreferencesTokenDatasource: SharedPreferencesTokenDatasource
    ): TokenDataSource
}