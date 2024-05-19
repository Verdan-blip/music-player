package ru.kpfu.itis.bagaviev.data.music.impl.data.network.search.di

import dagger.Module
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.search.di.submodules.SearchApiServiceDataModule
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.search.di.submodules.SearchRepositoryDataModule

@Module(
    includes = [
        SearchApiServiceDataModule::class,
        SearchRepositoryDataModule::class
    ]
)
interface SearchDataModule