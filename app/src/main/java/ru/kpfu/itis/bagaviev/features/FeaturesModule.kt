package ru.kpfu.itis.bagaviev.features

import dagger.Module
import ru.kpfu.itis.bagaviev.features.feed.di.FeatureFeedModule
import ru.kpfu.itis.bagaviev.features.oauth.di.FeatureOAuthModule
import ru.kpfu.itis.bagaviev.features.player.di.FeaturePlayerModule
import ru.kpfu.itis.bagaviev.features.profile.di.FeatureProfileModule
import ru.kpfu.itis.bagaviev.features.search.di.FeatureSearchModule
import ru.kpfu.itis.bagaviev.features.signin.di.FeatureSignInModule
import ru.kpfu.itis.bagaviev.features.signup.di.FeatureSignUpModule

@Module(
    includes = [
        FeatureOAuthModule::class,
        FeaturePlayerModule::class,
        FeatureFeedModule::class,
        FeatureSearchModule::class,
        FeatureSignInModule::class,
        FeatureSignUpModule::class,
        FeatureProfileModule::class
    ]
)
interface FeaturesModule