package ru.kpfu.itis.bagaviev.glue

import dagger.Module
import ru.kpfu.itis.bagaviev.glue.feed.di.FeatureFeedModule
import ru.kpfu.itis.bagaviev.glue.oauth.di.FeatureOAuthModule
import ru.kpfu.itis.bagaviev.glue.player.di.FeaturePlayerModule
import ru.kpfu.itis.bagaviev.glue.search.di.FeatureSearchModule

@Module(
    includes = [
        FeatureOAuthModule::class,
        FeaturePlayerModule::class,
        FeatureFeedModule::class,
        FeatureSearchModule::class
    ]
)
interface FeaturesModule