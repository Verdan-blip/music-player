package ru.kpfu.itis.bagaviev.feature.player.impl.di

import ru.kpfu.itis.bagaviev.common.di.connector.deps.ComponentDependencies
import ru.kpfu.itis.bagaviev.player.api.domain.interactor.MusicPlayerInteractor

interface PlayerComponentDependencies : ComponentDependencies {

    val musicPlayerInteractor: MusicPlayerInteractor
}