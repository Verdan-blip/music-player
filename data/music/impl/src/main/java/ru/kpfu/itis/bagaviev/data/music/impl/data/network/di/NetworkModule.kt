package ru.kpfu.itis.bagaviev.data.music.impl.data.network.di

import dagger.Module
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.auth.di.AuthDataModule
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.core.di.ApiCoreModule
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.core.di.client.PublicClientModule
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.core.di.retrofit.PublicRetrofitModule
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.feed.di.FeedDataModule
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.playlist.di.PlaylistDataModule
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.search.di.SearchDataModule
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.track.di.TrackDataModule
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.upload.di.UploadDataModule
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.upload.di.submodules.UploadApiServiceModule
import ru.kpfu.itis.bagaviev.data.music.impl.data.network.user.di.UserDataModule

@Module(
    includes = [
        AuthDataModule::class,
        PlaylistDataModule::class,
        SearchDataModule::class,
        TrackDataModule::class,
        UserDataModule::class,
        FeedDataModule::class,
        UploadDataModule::class,
        ApiCoreModule::class
    ]
)
class NetworkModule