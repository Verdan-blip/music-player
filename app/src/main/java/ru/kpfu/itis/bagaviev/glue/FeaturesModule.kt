package ru.kpfu.itis.bagaviev.glue

import dagger.Module
import ru.kpfu.itis.bagaviev.glue.oauth.di.OAuthModule

@Module(
    includes = [OAuthModule::class]
)
interface FeaturesModule