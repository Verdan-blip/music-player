package ru.kpfu.itis.bagaviev.di.deps

import ru.kpfu.itis.bagaviev.feed.impl.di.FeedComponentDependencies
import ru.kpfu.itis.bagaviev.player.impl.di.PlayerComponentDependencies
import ru.kpfu.itis.oauth.di.OAuthComponentDependencies

interface FeatureComponentsDependencies :
        OAuthComponentDependencies,
        PlayerComponentDependencies,
        FeedComponentDependencies