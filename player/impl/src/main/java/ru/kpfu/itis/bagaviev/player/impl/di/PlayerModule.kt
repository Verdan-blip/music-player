package ru.kpfu.itis.bagaviev.player.impl.di

import dagger.Module
import ru.kpfu.itis.bagaviev.player.impl.di.submodules.PlayerInteractorModule
import ru.kpfu.itis.bagaviev.player.impl.di.submodules.PlayerMediaControllerModule
import ru.kpfu.itis.bagaviev.player.impl.di.submodules.PlayerRepositoryModule

@Module(
    includes = [
        PlayerMediaControllerModule::class,
        PlayerInteractorModule::class,
        PlayerRepositoryModule::class
    ]
)
interface PlayerModule