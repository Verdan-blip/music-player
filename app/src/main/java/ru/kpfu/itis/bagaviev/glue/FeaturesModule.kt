package ru.kpfu.itis.bagaviev.glue

import dagger.Module
import ru.kpfu.itis.bagaviev.glue.oauth.di.OAuthModule
import ru.kpfu.itis.bagaviev.glue.player.di.PlayerModule

@Module(
    includes = [OAuthModule::class, PlayerModule::class]
)
interface FeaturesModule