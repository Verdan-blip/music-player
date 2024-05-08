package ru.kpfu.itis.bagaviev.glue.player.di

import dagger.Module
import ru.kpfu.itis.bagaviev.player.impl.di.PlayerModule

@Module(
    includes = [PlayerModule::class]
)
interface FeaturePlayerModule