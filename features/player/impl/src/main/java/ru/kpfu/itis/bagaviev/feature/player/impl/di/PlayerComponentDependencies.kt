package ru.kpfu.itis.bagaviev.feature.player.impl.di

import android.content.Context
import ru.kpfu.itis.bagaviev.common.di.connector.deps.ComponentDependencies
import ru.kpfu.itis.bagaviev.player.api.domain.interactor.MusicPlayerInteractor

interface PlayerComponentDependencies : ComponentDependencies {

    val musicPlayerInteractor: MusicPlayerInteractor

    val context: Context
}