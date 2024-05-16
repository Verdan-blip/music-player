package ru.kpfu.itis.bagaviev.features.player.di

import dagger.Module
import ru.kpfu.itis.bagaviev.player.impl.di.PlayerModule

@Module(
    includes = [PlayerModule::class]
)
interface FeaturePlayerModule