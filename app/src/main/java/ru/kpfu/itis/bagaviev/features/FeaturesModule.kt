package ru.kpfu.itis.bagaviev.features

import dagger.Module
import ru.kpfu.itis.bagaviev.features.feed.di.FeatureFeedModule
import ru.kpfu.itis.bagaviev.features.player.di.FeaturePlayerModule
import ru.kpfu.itis.bagaviev.features.profile.di.FeatureProfileModule
import ru.kpfu.itis.bagaviev.features.search.di.FeatureSearchModule
import ru.kpfu.itis.bagaviev.features.signin.di.FeatureSignInModule
import ru.kpfu.itis.bagaviev.features.signup.di.FeatureSignUpModule
import ru.kpfu.itis.bagaviev.features.upload.di.FeatureUploadModule

@Module(
    includes = [
        FeaturePlayerModule::class,
        FeatureFeedModule::class,
        FeatureSearchModule::class,
        FeatureSignInModule::class,
        FeatureSignUpModule::class,
        FeatureProfileModule::class,
        FeatureUploadModule::class
    ]
)
interface FeaturesModule