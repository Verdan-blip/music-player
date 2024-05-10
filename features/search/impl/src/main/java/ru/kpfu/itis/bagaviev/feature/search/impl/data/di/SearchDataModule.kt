package ru.kpfu.itis.bagaviev.feature.search.impl.data.di

import dagger.Module
import ru.kpfu.itis.bagaviev.feature.search.impl.data.playlists.di.PlaylistRepositoryModule
import ru.kpfu.itis.bagaviev.feature.search.impl.data.search.di.SearchRepositoryModule
import ru.kpfu.itis.bagaviev.feature.search.impl.data.tracks.di.TrackRepositoryModule

@Module(
    includes = [
        PlaylistRepositoryModule::class,
        TrackRepositoryModule::class,
        SearchRepositoryModule::class
    ]
)
internal interface SearchDataModule