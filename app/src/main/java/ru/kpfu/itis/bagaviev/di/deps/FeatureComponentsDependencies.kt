package ru.kpfu.itis.bagaviev.di.deps

import ru.kpfu.itis.bagaviev.feed.impl.di.FeedComponentDependencies
import ru.kpfu.itis.bagaviev.feature.player.impl.di.PlayerComponentDependencies
import ru.kpfu.itis.bagaviev.feature.profile.di.ProfileComponentDependencies
import ru.kpfu.itis.bagaviev.feature.search.impl.di.SearchComponentDependencies
import ru.kpfu.itis.bagaviev.feature.signin.di.SignInComponentDependencies
import ru.kpfu.itis.bagaviev.feature.signup.di.SignUpComponentDependencies
import ru.kpfu.itis.bagaviev.feature.upload.di.UploadComponentDependencies
import ru.kpfu.itis.oauth.di.OAuthComponentDependencies

interface FeatureComponentsDependencies :
    OAuthComponentDependencies,
    PlayerComponentDependencies,
    FeedComponentDependencies,
    SearchComponentDependencies,
    SignUpComponentDependencies,
    SignInComponentDependencies,
    ProfileComponentDependencies,
    UploadComponentDependencies