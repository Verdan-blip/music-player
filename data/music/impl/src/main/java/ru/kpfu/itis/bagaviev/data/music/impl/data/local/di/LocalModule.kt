package ru.kpfu.itis.bagaviev.data.music.impl.data.local.di

import dagger.Module
import ru.kpfu.itis.bagaviev.data.music.impl.data.local.music.di.DownloadedMusicModule
import ru.kpfu.itis.bagaviev.data.music.impl.data.local.token.di.LocalTokenModule

@Module(
    includes = [
        LocalTokenModule::class,
        DownloadedMusicModule::class
    ]
)
interface LocalModule