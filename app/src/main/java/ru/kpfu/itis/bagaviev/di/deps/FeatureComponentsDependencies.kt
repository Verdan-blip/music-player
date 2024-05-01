package ru.kpfu.itis.bagaviev.di.deps

import ru.kpfu.itis.bagaviev.impl.di.FeedComponentDependencies
import ru.kpfu.itis.bagaviev.impl.di.PlayerComponentDependencies
import ru.kpfu.itis.oauth.di.OAuthComponentDependencies

interface FeatureComponentsDependencies :
        OAuthComponentDependencies,
        PlayerComponentDependencies,
        FeedComponentDependencies