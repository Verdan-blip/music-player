package ru.kpfu.itis.bagaviev.player.impl.di

import dagger.Module

@Module(
    includes = [
        PlayerMediaControllerModule::class,
        PlayerInteractorModule::class,
        PlayerRepositoryModule::class
    ]
)
interface PlayerModule