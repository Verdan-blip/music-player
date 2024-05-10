package ru.kpfu.itis.bagaviev.glue.search.di

import dagger.Module
import ru.kpfu.itis.bagaviev.data.music.impl.data.di.MusicDataModule
import ru.kpfu.itis.bagaviev.player.impl.di.PlayerModule

@Module(
    includes = [
        PlayerModule::class,
        MusicDataModule::class
    ]
)
interface FeatureSearchModule